package com.danzaseimily.app.services.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("account")
public class Account {

    @NotNull
    @NotEmpty
    @Id
    private String _id;
    @NotNull
    @NotEmpty
    private String usernameEmail;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotEmpty
    @NotNull
    private String lastName;

    @NotNull
    private String photo;
    @NotNull
    private String fingerPrint;
    @NotNull
    @Min(6)
    @Max(40)
    private Integer age;

    public Account() {
    }

    public String get_id() {
        return _id.toLowerCase();
    }

    public void set_id(String _id) {
        this._id = _id.toLowerCase();
    }

    public String getUsernameEmail() {
        return usernameEmail;
    }

    public void setUsernameEmail(String usernameEmail) {
        this.usernameEmail = usernameEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
