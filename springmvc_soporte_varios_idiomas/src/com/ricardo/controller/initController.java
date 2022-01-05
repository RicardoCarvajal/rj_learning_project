package com.ricardo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ricardo.model.Usuario;

@Controller
@RequestMapping("/initController")
public class initController {

    @RequestMapping("/inicio")
    public ModelAndView helloController() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("usuario", new Usuario());
        mv.setViewName("loginapplication");
        return mv;

    }

    @RequestMapping("/salida")
    public ModelAndView helloController(@Valid Usuario usuario, BindingResult result, Locale locale) {

        ModelAndView mv = new ModelAndView();

        System.out.println(result.getAllErrors());

        if (result.hasErrors()) {
            mv.addObject("usuario", usuario);
            mv.setViewName("loginapplication");

        } else {
            mv.addObject("usuario", usuario);
            mv.setViewName("salidaExitosa");

        }

        return mv;

    }

}
