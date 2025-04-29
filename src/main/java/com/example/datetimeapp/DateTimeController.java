package com.example.datetimeapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
    private static final DateTimeFormatter dateFormatter = 
        DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
    private static final DateTimeFormatter timeFormatter = 
        DateTimeFormatter.ofPattern("hh:mm:ss a");
        
        @GetMapping("/api/current-datetime")
        public Map<String, String> getCurrentDateTime() {
            LocalDateTime now = LocalDateTime.now();
            Map<String, String> datetime = new HashMap<>();
            datetime.put("date", now.format(dateFormatter));
            datetime.put("time", now.format(timeFormatter));
            return datetime;
        }
}

