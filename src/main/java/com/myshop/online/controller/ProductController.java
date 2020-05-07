package com.myshop.online.controller;



import com.myshop.online.dto.ProductDTO;
import com.myshop.online.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductController {
    private final ProductService productService;


   /* @Autowired
    private ProductService service;

    @PostMapping ("/addProduct")
    public Product addProduct( @Valid @RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping ("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping ("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }

    @GetMapping ("/idproduct/{id}")
    public Product findProductById(@PathVariable int id){
        return  service.getProductById(id);
    }

    @GetMapping ("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return  service.getProductByName(name);
    }

    @PutMapping ("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return  service.deleteProduct(id);
    }*/
}

