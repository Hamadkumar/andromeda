package com.io.andromeda.com.io.andromeda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Keno&Kemo on 30.09.2017..
 */

@Controller
@RequestMapping("")
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String index (){
        return "index";
    }

    @GetMapping(value = "/home")
    public String home (){
        return "home";
    }
    
    @GetMapping(value = "/aboutus")
    public String aboutus (){
        return "about-us";
    }
    
    @GetMapping(value = "/checkout")
    public String checkout (){
        return "checkout";
    }

    @GetMapping(value = "/menudetails")
    public String menudetails (){
        return "menu-details";
    }
    
    @GetMapping(value = "/contact")
    public String contact (){
        return "contact";
    }
    
    @GetMapping(value = "/menulist")
    public String menulist (){
        return "menu-list";
    }
    @GetMapping(value = "/cart")
    public String showRegistrationForm(WebRequest request, Model model) {
        return "cart";
    }
}
