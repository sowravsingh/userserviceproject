package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userservice;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long id){
        User user= userservice.getUser(id);
        List contacts =this.restTemplate.getForObject("http://contact-service/contact/"+id,List.class);
        user.setContacts(contacts);
        return user;
    }

}
