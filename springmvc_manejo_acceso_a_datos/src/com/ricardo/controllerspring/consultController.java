package com.ricardo.controllerspring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class consultController {

    private static Date dNow = new Date();

    private static SimpleDateFormat ft = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

    private static String currentDate = ft.format(dNow);

    public static String getCurrentDate() {
        return currentDate;
    }

    @RequestMapping("/consultController")
    public ModelAndView consultsController() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", getCurrentDate());
        mv.addObject("tittle", "Consulta");
        mv.addObject("application", "Aplicación");
        mv.addObject("name_button_seeform", "Consultar");
        mv.addObject("pos_number_label", "Introdusca el numero de la caja");
        mv.setViewName("seepos");

        return mv;

    }

}
