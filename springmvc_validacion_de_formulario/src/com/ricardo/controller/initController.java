package com.ricardo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ricardo.model.Usuario;

@Controller
@RequestMapping("/initController")
public class initController {

    @RequestMapping("/inicio")
    public ModelAndView helloController() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("user_password", "Usuario");
        mv.addObject("password", "Clave");
        mv.addObject("name_button_login", "Ingresar");
        mv.addObject("usuario", new Usuario());
        mv.setViewName("loginapplication");
        return mv;

    }

    @RequestMapping(value = "/salida",
                    method = RequestMethod.POST)
    public ModelAndView helloController(@Valid Usuario usuario, BindingResult result) {

        ModelAndView mv = new ModelAndView();

        System.out.println(result.getAllErrors());

        if (result.hasErrors()) {
            mv.addObject("user_password", "Usuario");
            mv.addObject("password", "Clave");
            mv.addObject("name_button_login", "Ingresar");
            mv.addObject("usuario", usuario);
            mv.setViewName("loginapplication");

        } else {
            mv.addObject("user_password", "Usuario");
            mv.addObject("password", "Clave");
            mv.addObject("name_button_login", "Ingresar");
            mv.addObject("usuario", usuario);
            mv.setViewName("salidaExitosa");

        }

        return mv;

    }

}
