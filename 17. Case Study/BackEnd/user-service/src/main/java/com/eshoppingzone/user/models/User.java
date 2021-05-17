package com.eshoppingzone.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int isSeller;
}
