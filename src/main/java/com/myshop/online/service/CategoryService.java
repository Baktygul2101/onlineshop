package com.myshop.online.service;


import com.myshop.online.dto.CategoryDTO;
import com.myshop.online.exception.ResourceNotFoundException;
import com.myshop.online.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository catRepo;

    public Page<CategoryDTO> getCategories(Pageable pageable) {
        return catRepo.findAll(pageable)
                .map(CategoryDTO::from);
        //.toList();
    }

    public CategoryDTO getCategory(int id) {
        var category = catRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("category", id));
        return CategoryDTO.from(category);
    }
}
