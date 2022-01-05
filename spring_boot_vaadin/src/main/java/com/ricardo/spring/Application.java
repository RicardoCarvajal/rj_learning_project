package com.ricardo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@RestController
@EnableAutoConfiguration
@SpringUI(path = "/home")
public class Application extends UI {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout layout = new VerticalLayout();

        Label label = new Label("Integración Spring Boot - Vaadin");
        Button button = new Button("click", e -> Notification.show("Hola Vaadin/Spring Boot"));

        layout.addComponent(label);
        layout.addComponent(button);

        setContent(layout);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
