package com.myshop.online.controller;

import com.myshop.online.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    @GetMapping("/register")
    public String pageRegistrationCustomer(Model model) {
        if(!model.containsAttribute("form")){
            model.addAttribute("form", new Customer());
        }

        return "register";
    }

    @PostMapping("/register")
    public String RegistrationPage(@Valid Customer form,
                                   BindingResult validationResult,
                                   RedirectAttributes attributes) {
        attributes.addFlashAttribute("form", form);


        if(validationResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }

        return "redirect:/";
    }

    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex){
        var apiFieldErrors=ex.getFieldErrors()
                .stream()
                .map(fe->String.format("%s ->%s",fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }

}