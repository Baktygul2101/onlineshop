package com.myshop.online.frontend;


import com.myshop.online.exception.ResourceNotFoundException;
import com.myshop.online.service.CategoryService;
import com.myshop.online.service.ProductService;
import com.myshop.online.service.PropertiesService;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {
    private final CategoryService catService;
    private final ProductService prodService;
    private final PropertiesService propertiesService;

    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }
    @GetMapping
    public String index(Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        var categories = catService.getCategories(pageable);
        var uri = uriBuilder.getRequestURI();
        constructPageable(categories, propertiesService.getDefaultPageSize(), model, uri);

        return "index";
    }

    @GetMapping("/categories/{id:\\d+?}")
    public String placePage(@PathVariable int id, Model model, Pageable pageable, HttpServletRequest uriBuilder) {
        model.addAttribute("category", catService.getCategory(id));
        var uri = uriBuilder.getRequestURI();
        var products = prodService.getProducts(id, pageable);
        constructPageable(products, propertiesService.getDefaultPageSize(), model, uri);

        return "category";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }

}