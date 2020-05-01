package com.myshop.online.controller;



import com.myshop.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    ProductRepository repo;

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }

    @RequestMapping("/jql/{name}")
    public String getMainPageJql(Model model, @PathVariable("name") String name) {
        model.addAttribute("products", repo.getByName(name));
        return "index";
    }

}
