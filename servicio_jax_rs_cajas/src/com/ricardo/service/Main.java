package com.ricardo.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.ricardo.service.resources.ArticleResource;

public class Main extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    private Set<Class<?>> empty = new HashSet<Class<?>>();

    public Main() {
        singletons.add(new ArticleResource());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return empty;
    }

}
