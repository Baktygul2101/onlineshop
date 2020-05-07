package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column
    @Size(min = 4, max = 24, message = "Length must be ⩾ 4 and ⩽ 24")
    @Pattern(regexp = "^[^\\d\\s]+$", message = "Should contain only letters")
    private String name;


    @NotBlank
    @Size(min = 8, max = 128)
    @Column
    private String address;

    @NotBlank
    @Size(min = 6, max = 12)
    @Column(length = 128)
    private String phoneNumber;

    @NotBlank
    @Column
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max =12)
    @Column(length = 128)
    private String password;



}













