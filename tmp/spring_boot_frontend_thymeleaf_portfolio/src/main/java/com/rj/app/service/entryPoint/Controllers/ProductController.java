package com.rj.app.service.entryPoint.Controllers;

import com.rj.app.service.domain.services.ProjectService;
import com.rj.app.service.entryPoint.dto.ProjectRequestDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductController {

    private final ProjectService projectService;

    public ProductController(ProjectService productService) {
        this.projectService = productService;
    }

    @GetMapping({"/lista", "/"})
    public Mono<String> getLista(Model model) {
        Flux<ProjectRequestDto> product = projectService.getProjects().map(p ->
            {
                p.setName(p.getName().toUpperCase());
                return p;
            });
        model.addAttribute("titulo", "Listado de proyectos");
        model.addAttribute("proyectos", product);
        return Mono.just("lista");
    }

    @GetMapping("/form")
    public Mono<String> create(Model model) {
        model.addAttribute("titulo","Formulario de proyectos");
        model.addAttribute("project",new ProjectRequestDto());
        return Mono.just("form");
    }


    @GetMapping("/form-v2/{id}")
    public Mono<String> editV2(@PathVariable String id, Model model){
        return projectService.getProject(id).doOnNext(project -> {
            System.out.println("Project: " + project.getName());
            model.addAttribute("titulo","Editar proyecto");
            model.addAttribute("project",project);
        }).defaultIfEmpty(new ProjectRequestDto())
                .flatMap(project -> {
                    if(project.getId() == null){
                        return Mono.error(new InterruptedException());
                    }
                    return Mono.just(project);
                })
                .then(Mono.just("form"))
                .onErrorResume(ex -> Mono.just("redirect:/lista?error=Producto+no+existe"));
    }
    @GetMapping("/form-v1/{id}")
    public Mono<String> editV1(@PathVariable String id, Model model){
        Mono<ProjectRequestDto> monoProject = projectService.getProject(id).doOnNext(project -> {
           System.out.println("Project: " + project.getName());
        }).defaultIfEmpty(new ProjectRequestDto());

        model.addAttribute("titulo","Editar proyecto");
        model.addAttribute("project",monoProject);

        return Mono.just("form");
    }

    @PostMapping("/form")
    public Mono<String> save(@Valid @ModelAttribute("project") ProjectRequestDto project, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("titulo","Errores en registro de proyectos");
            return Mono.just("form");
        }else {
            return projectService.saveProject(project).thenReturn("redirect:/lista?success=Proyecto+guardado+con+exito");
        }
    }

    @GetMapping("/delete/{id}")
    public Mono<String> delete(@PathVariable String id){
        return projectService.getProject(id)
                .defaultIfEmpty(new ProjectRequestDto())
                .flatMap(p -> {
                    if(p.getId() == null){
                        return Mono.error(new InterruptedException("No existe el proyecto"));
                    }
                    return Mono.just(p);
                })
                .flatMap(p ->{
            return projectService.delete(p.getId());
        }).then(Mono.just("redirect:/lista?success=Proyecto+eliminado+con+exito"))
                .onErrorResume(ex -> Mono.just("redirect:/lista?error=Producto+no+existe"));
    }

/*Manejando la contra-presion desde el frontend, el metodo
    delayElements(Duration.ofSeconds(1)) es solo para forzar el ejemplo

    @GetMapping("/lista-data")
    public String getListaDataDriver(Model model) {
        Flux<ProjectRequestDto> product = productService.getProducts().map(p ->
        {
            p.setName(p.getName().toUpperCase());
            return p;
        }).delayElements(Duration.ofSeconds(1));
        model.addAttribute("titulo", "Listado de proyectos");
        model.addAttribute("proyectos", new ReactiveDataDriverContextVariable(product,1));
        return "lista";
    }
*/

/*Manejando la contra-presion desde el frontend, el metodo
    delayElements(Duration.ofSeconds(1)) es solo para forzar el ejemplo
    este ejemplo se maneja ja contraprecion por bytes y no por elementos

    @GetMapping("/lista-full")
    public String getListaFull(Model model) {
        Flux<ProjectRequestDto> product = productService.getProducts().map(p ->
        {
            p.setName(p.getName().toUpperCase());
            return p;
        }).repeat(5000);
        model.addAttribute("titulo", "Listado de proyectos");
        model.addAttribute("proyectos", product);
        return "lista";
    }
*/

}


