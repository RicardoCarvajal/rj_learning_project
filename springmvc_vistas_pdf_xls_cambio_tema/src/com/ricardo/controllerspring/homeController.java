package com.ricardo.controllerspring;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {

    @RequestMapping("/homeController")
    public ModelAndView homeBeforeIndexController() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("date", LocalDate.now());
        mv.setViewName("home");
        return mv;

    }

}
