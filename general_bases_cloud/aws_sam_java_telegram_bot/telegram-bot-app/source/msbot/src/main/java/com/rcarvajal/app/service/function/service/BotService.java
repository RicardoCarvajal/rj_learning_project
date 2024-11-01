package com.rcarvajal.app.service.function.service;

import com.rcarvajal.app.service.function.dto.BodyRequest;

public interface BotService {
    void sendMessage(BodyRequest request);
}
