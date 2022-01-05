package com.ricardo.Practica_8_springmvc_configuracion_con_java_simplificado;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PruebaController {

    @RequestMapping("/pruebaController")
    public ModelAndView helloController() {

        // String message = "<br>" + "<div style='text-align:center;'>" + "<h2>Hola Mundo
        // Spring MVC!</h2>"
        // + "Mensaje del Controller de Spring" + "</div><br><br>";
        //
        // return new ModelAndView("respuesta", "message", message);

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "<h2> Trabajando con spring </h2>");
        mv.setViewName("respuesta");

        return mv;

    }

}
