package com.example.CleanList.Controllers;

import com.example.CleanList.Services.NagerDateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/date")
public class DateController {
    private final NagerDateService holidayService;

    public DateController(NagerDateService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String date){
        LocalDate d = LocalDate.parse(date);
        return holidayService.isHolidayOrWeekend(d);
    }
}
