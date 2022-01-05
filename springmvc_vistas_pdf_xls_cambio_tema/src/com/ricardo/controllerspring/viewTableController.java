package com.ricardo.controllerspring;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ricardo.configspring.ConfiguracionAccesoBaseDatos;
import com.ricardo.model.entity.Caja;
import com.ricardo.repositorio.RepositorioCajas;

@Controller
public class viewTableController {

    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(ConfiguracionAccesoBaseDatos.class);

    RepositorioCajas caja = ctx.getBean(RepositorioCajas.class);

    @ModelAttribute("cajaList")
    public Iterable<Caja> getCajaList() {
        return caja.findAll();
    }

    @ModelAttribute("date")
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @RequestMapping("/viewTableController")
    public String showPage(Model model) {
        return "seepos";
    }

    @RequestMapping("/pdf")
    public String generarPdf(Model model) {
        return "pdfView";
    }

    @RequestMapping("/xls")
    public String generarXls(Model model) {
        return "xlsView";
    }

}
