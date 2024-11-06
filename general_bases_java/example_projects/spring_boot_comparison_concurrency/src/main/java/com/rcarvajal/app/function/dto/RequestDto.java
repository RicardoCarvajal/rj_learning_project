package com.rcarvajal.app.function.dto;

public class RequestDto {
    private Integer tr;
    private String pos;
    private String store;

    public RequestDto() {
    }

    public Integer getTr() {
        return tr;
    }

    public void setTr(Integer tr) {
        this.tr = tr;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
