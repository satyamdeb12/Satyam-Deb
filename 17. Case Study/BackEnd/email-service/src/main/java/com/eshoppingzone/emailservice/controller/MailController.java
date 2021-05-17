package com.eshoppingzone.emailservice.controller;

import com.eshoppingzone.emailservice.models.MailModel;
import com.eshoppingzone.emailservice.service.EmailService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Slf4j
public class MailController {

    @Autowired
    private EmailService service;

    @GetMapping("/login/{email}")
    @ApiOperation(value = "Send Successful login Email.",
            notes = "Provide the email id in the url.",
            response = MailModel.class)
    public void sendMail(@PathVariable( "email") String email){
        log.info("sendMail method of MailController is called.");
        service.sendSimpleEmail(email, "You Have Successfully Logged In", "EShoppingZone LOGIN ALERT");
    }
}
