package com.danzaseimily.app.service.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

public class Registration {
    @Id
    private String id;
    @CreatedDate
    private String ceatedDate;
    @LastModifiedDate
    private String modifiedDate;
    private String fingerPrint;

}
