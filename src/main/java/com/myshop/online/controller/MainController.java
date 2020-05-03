package com.myshop.online.controller;



import com.myshop.online.model.Product;
import com.myshop.online.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    ProductRepository repo;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

 //  <p>${pr.id} - ${pr.name} - ${pr.image} - ${pr.quantity} -${pr.description}-${pr.price}</p>
  //  @GetMapping
  /*  public String root(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }*/



 /*   @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }

    @GetMapping("/jql/{name}")
    public String getMainPageJql(Model model, @PathVariable("name") String name) {
        model.addAttribute("products", repo.getByName(name));
        return "index";
    }*/

}
