package com.rcarvajal.app.service.infraestructure.web;


public interface Delivery<T> {
    void send(T model);
}
