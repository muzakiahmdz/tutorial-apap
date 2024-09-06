
package com.tutorial.romanconverter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutorial.romanconverter.model.RomanConverter;




@Controller
public class RomanConverterController {
    @GetMapping(value = "/")
    public String home(Model model) {
        return "view-home.html";
    }
    @GetMapping(value = "/roman-converter/{roman}")
    public String romanConverterWithPathVariable(@PathVariable(value = "roman") String roman, Model model) {
        return getRomanConverterPage(roman, model);
    }

private String getRomanConverterPage(String roman, Model model) {
        final RomanConverter romanConverter = new RomanConverter(roman);
        model.addAttribute("romanConverter", romanConverter);
        return "view-conversion-result.html";
    }

}
    

