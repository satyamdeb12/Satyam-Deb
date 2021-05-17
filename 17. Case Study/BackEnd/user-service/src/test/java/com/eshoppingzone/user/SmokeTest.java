package com.eshoppingzone.user;

import static org.assertj.core.api.Assertions.assertThat;

import com.eshoppingzone.user.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
