package com.example.CleanList.Holiday;

import lombok.Data;

@Data
public class CalendarificHoliday {
    private String name;
    private String description;
    private CalendarificDate date;
}
