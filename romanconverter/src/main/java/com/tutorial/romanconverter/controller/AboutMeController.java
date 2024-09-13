
package com.tutorial.romanconverter.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.romanconverter.dto.RequestDTO;
import com.tutorial.romanconverter.model.RomanConverter;

@Controller
public class AboutMeController{
    @GetMapping(value = "/about-me/{NPM}")
    public String aboutMe(@PathVariable(value = "NPM") String NPM, Model model) {
        if(NPM.equals("2206824924")){
            model.addAttribute("Nama", "Muzaki Ahmad Ridho Azizy");
            model.addAttribute("NPM", "2206824924");
            return "view-aboutme.html";
    }
    model.addAttribute("error", "salah kocak");
    return "eror-npm.html";
    }
}