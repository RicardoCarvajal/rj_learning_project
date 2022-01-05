package com.ricardo.controllerspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ricardo.configspring.ConfiguracionAccesoBaseDatos;
import com.ricardo.repositorio.RepositorioCajas;

@Controller
public class resultadoConsultaController {

    @RequestMapping("/resultadoConsultaController")
    @ResponseBody
    public String resultController(@RequestParam("number") Long number) {

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
                ConfiguracionAccesoBaseDatos.class);

        RepositorioCajas caja = ctx.getBean(RepositorioCajas.class);

        return caja.findAll().toString();

    }

}
