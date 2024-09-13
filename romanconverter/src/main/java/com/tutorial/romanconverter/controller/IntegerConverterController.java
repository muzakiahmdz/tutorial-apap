package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tutorial.romanconverter.dto.IntegerRequestDTO;
import com.tutorial.romanconverter.model.IntegerConverter;

@Controller
public class IntegerConverterController {

    @GetMapping(value = "/convert-integer")
    public String getIntegerConverterForm(Model model) {
        model.addAttribute("integerRequestDTO", new IntegerRequestDTO());
        return "form-integer-converter.html";
    }

    @PostMapping(value = "/convert-integer")
    public String postIntegerConverterForm(@ModelAttribute IntegerRequestDTO integerRequestDTO, Model model) {
        int integerValue = integerRequestDTO.getIntegerValue();
        IntegerConverter integerConverter = new IntegerConverter(integerValue);
        model.addAttribute("integerConverter", integerConverter);
        return "view-conversion-result-integer.html";
    }
}
