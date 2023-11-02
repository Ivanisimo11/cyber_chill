package com.cyber_chill.controller;

import com.cyber_chill.entity.User;
import com.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public String getContact(){
        return contactService.generateContacts();
    }

}
