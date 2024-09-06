
package com.tutorial.romanconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class RomanConverterController {


    @GetMapping(value = "/")
    public String home(Model model) {
        return "view-home.html";
    }
}

