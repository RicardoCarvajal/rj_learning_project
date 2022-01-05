package com.ricardo.controllerspring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class initController {

    private static Date dNow = new Date();

    private static SimpleDateFormat ft = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

    private static String currentDate = ft.format(dNow);

    public static String getCurrentDate() {
        return currentDate;
    }

    @RequestMapping("/initController")
    public ModelAndView helloController() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", getCurrentDate());
        mv.addObject("tittle", "Login");
        mv.addObject("application", "Aplicación");
        mv.setViewName("loginapplication");

        return mv;

    }

}
