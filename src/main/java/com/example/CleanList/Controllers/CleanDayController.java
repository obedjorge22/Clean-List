package com.example.CleanList.Controllers;

import com.example.CleanList.Services.CleanDayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/day")
public class CleanDayController {
    private final CleanDayService cleanDayService;

    @GetMapping
    public Object getDayInfo(@RequestParam(required = false) String date){
        LocalDate today = (date == null) ? LocalDate.now() : LocalDate.parse(date);
        return cleanDayService.checkDay(today);
    }
}
