package com.example.datetime_app;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
    @GetMapping("/")
    public String showDateTime(Model model) {
        model.addAttribute("currentDateTime", LocalDateTime.now());
        return "datetime";
    }
}