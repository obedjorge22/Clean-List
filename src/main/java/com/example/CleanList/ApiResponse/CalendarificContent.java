package com.example.CleanList.ApiResponse;

import com.example.CleanList.Holiday.CalendarificHoliday;
import lombok.Data;

import java.util.List;

@Data
public class CalendarificContent {
    private List<CalendarificHoliday> holidays;
}
