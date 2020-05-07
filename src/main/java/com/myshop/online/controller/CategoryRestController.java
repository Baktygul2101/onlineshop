package com.myshop.online.controller;

import com.myshop.online.dto.CategoryDTO;
import com.myshop.online.dto.ProductDTO;
import com.myshop.online.service.CategoryService;
import com.myshop.online.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class CategoryRestController {
    private final CategoryService categService;
    private final ProductService prodService;

    @GetMapping
    public List<CategoryDTO> getCategories(Pageable pageable) {
        return categService.getCategories(pageable).getContent();
    }

    @GetMapping("/{id:\\d+?}")
    public CategoryDTO categoryPage(@PathVariable int id) {
        return categService.getCategory(id);
    }

    @GetMapping("/{id:\\d+}/products")
    public List<ProductDTO> getFoods(@PathVariable @Min(5) int id, Pageable pageable) {
        return prodService.getProducts(id, pageable).getContent();
    }
}
