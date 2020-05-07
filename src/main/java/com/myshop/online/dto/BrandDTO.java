package com.myshop.online.dto;


import com.myshop.online.model.Brand;
import com.myshop.online.model.Category;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrandDTO{
    private Integer id;
    private String brandName;

    public static BrandDTO from(Brand brand) {
        return builder()
                .id(brand.getId())
                .brandName(brand.getBrandName())
                .build();
    }

}
