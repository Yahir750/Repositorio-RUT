package com.ReUseTech.com.ReUseTech.dto;


import lombok.Data;

@Data
public class EmailConfirmationRequest {
    private String email;
    private String confirmationCode;
}