package com.myshop.online.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.myshop.online.model.CustomerRegistrationForm;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {

    @GetMapping("/register")
    public String pageRegistrationCustomer(Model model) {
        if(!model.containsAttribute("form")){
            model.addAttribute("form", new CustomerRegistrationForm());
        }

        return "register";
    }

    @PostMapping("/register")
    public String RegistrationPage(@Valid CustomerRegistrationForm form,
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