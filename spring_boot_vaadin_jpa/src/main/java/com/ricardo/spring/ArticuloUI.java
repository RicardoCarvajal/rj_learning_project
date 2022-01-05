package com.ricardo.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.ricardo.models.Articulo;
import com.ricardo.services.ArticuloServices;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@Title("Articles")
@SpringUI(path = "/Articles")
public class ArticuloUI extends UI {

    @Autowired
    private ArticuloServices articles;

    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout layout = new VerticalLayout();

        Label title = new Label("Articulos  en caja");

        Grid<Articulo> grid = new Grid<>(Articulo.class);

        grid.setColumns("id", "codigo", "nombre");

        grid.setItems(articles.findAll());

        grid.setSizeFull();

        layout.addComponent(title);
        layout.addComponent(grid);

        setContent(layout);

    }

}
