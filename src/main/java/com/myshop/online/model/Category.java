package com.myshop.online.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "categories")
public class Category{
    @Id
    @GeneratedValue
    private int id;
    @NotBlank
    private String categoryName;
    @NotNull
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @OrderBy("name ASC")
    List<Product> products;
}