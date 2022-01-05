package com.rj.lambda;

import java.util.ArrayList;
import java.util.List;

import com.rj.lambda.models.Article;

public class General_example {

    public static void main(String[] args) {

        List<Article> listArticles = new ArrayList<Article>();

        listArticles.add(new Article("Arroz", 23098, "arroz de 1 Kg"));
        listArticles.add(new Article("Pasta", 25899, "pasta de 1 Kg"));
        listArticles.add(new Article("Azucar", 21523, "azucar de 1 Kg"));

        listArticles.sort((Article o1, Article o2) -> -(o1.getCode().compareTo(o2.getCode())));

        listArticles.stream()
                .forEach(articles -> System.out.println(articles.getCode() + " " + articles.getName()));

    }

}
