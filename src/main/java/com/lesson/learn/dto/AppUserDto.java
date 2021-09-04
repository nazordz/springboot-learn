package com.lesson.learn.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.lesson.learn.models.entities.AppUserRole;

public class AppUserDto {
    
    private String fullName;

    @NotEmpty(message = "Email harus diisi")
    @Email
    private String email;

    @NotEmpty(message = "Password harus diisi")
    private String password;

    private AppUserRole appUserRole;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(AppUserRole appUserRole) {
        this.appUserRole = appUserRole;
    }

    
}
