package com.ricardo.service.resources;

import java.net.URI;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.becoblohm.cr.crjpa.controller.ArticuloJpaController;
import com.becoblohm.cr.crjpa.controller.exceptions.JpaException;
import com.becoblohm.cr.models.Article;

@Path("/articles")
public class ArticleResource {

    public ArticleResource() {

    }

    protected static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CRJPAPU");

    ArticuloJpaController articuloJpa = new ArticuloJpaController(EMF);

    @GET
    @Path("/code")
    public Response getArticle(@QueryParam("number") String code) {

        Article article = new Article();

        try {
            article = articuloJpa.findArticle(code);
            return Response.created(URI.create("/articles/" + article.getId())).build();
        } catch (JpaException e) {
            return Response.serverError().build();
        }

    }

}
