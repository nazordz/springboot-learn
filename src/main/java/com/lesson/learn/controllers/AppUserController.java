package com.lesson.learn.controllers;

import javax.validation.Valid;

import com.lesson.learn.dto.AppUserDto;
import com.lesson.learn.dto.ResponseData;
import com.lesson.learn.models.entities.AppUser;
import com.lesson.learn.services.AppUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@Valid @RequestBody AppUserDto appUserDto) {
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(appUserDto, AppUser.class);
        System.out.println(appUser);
        responseData.setPayload(appUserService.register(appUser));
        responseData.setStatus(true);
        responseData.getMessages().add("Berhasil didaftarkan");

        return ResponseEntity.ok(responseData);
    }
}
