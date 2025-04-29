package com.example.datetimeapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@Controller
public class DateTimeController {
    @GetMapping("/")
    public String showDateTime(Model model) {
        model.addAttribute("currentDateTime", LocalDateTime.now());
        return "datetime";
    }
}

