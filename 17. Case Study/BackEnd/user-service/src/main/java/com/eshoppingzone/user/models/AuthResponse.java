package com.eshoppingzone.user.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private int status;
    private String message;
    private String userName;
    private int isSeller;
}
