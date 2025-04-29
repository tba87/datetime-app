package com.example.datetimeapp;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DateTimeController {
    @GetMapping("/")
    public String showDateTime(Model model) {
        model.addAttribute("currentDateTime", LocalDateTime.now());
        return "datetime";
    }
    @GetMapping("/current-time")
    @ResponseBody
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }
}

