package com.intelix.mcp.server.model;

import java.util.ArrayList;
import java.util.List;

public class RequestData {

    private List<String> articles = new ArrayList<>();

    private List<String> stores = new ArrayList<>();

    public RequestData() {
    }


    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles.addAll(articles);
    }

    public List<String> getStores() {
        return stores;
    }

    public void setStores(List<String> stores) {
        this.stores.addAll(stores);
    }
}
