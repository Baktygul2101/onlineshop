package com.myshop.online.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerRegistrationForm {
    @NotBlank
    @Email
    private  String email = "";
//
//    @NotBlank
//    @Email
//    private  String password = " ";

    @Size(min = 4, max = 24, message = "Length must be ⩾ 4 and ⩽ 24")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "Should contain only letters")
    private  String name = "";
}