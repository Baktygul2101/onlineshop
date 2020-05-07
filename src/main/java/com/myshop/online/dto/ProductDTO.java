package com.myshop.online.dto;

import com.myshop.online.model.Brand;
import com.myshop.online.model.Category;
import com.myshop.online.model.Product;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDTO {
    private Integer id;
    private String name;
    private String image;
    private int quantity;
    private String description;
    private double price;
    private Category category;
    private Brand brand;

    public static ProductDTO from(Product product) {
        return builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(CategoryDTO.from(product.getCategory()))
                .build();
    }

}

