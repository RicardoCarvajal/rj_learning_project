package com.rcarvajal.app.service.infraestructure.web;


import com.rcarvajal.app.service.function.dto.BodyRequest;

public interface Delivery {
    void send(BodyRequest model);
}
