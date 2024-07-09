package com.huandv.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/22/2024 4:02 PM
 * @Author: crist
 */
@RestController
@RequestMapping
public class AccountController {

    @GetMapping("/getAccount")
    public String getAccount(){
        return "abc";
    }

}
