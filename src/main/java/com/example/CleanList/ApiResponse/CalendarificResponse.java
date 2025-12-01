package com.example.CleanList.ApiResponse;

import com.example.CleanList.Holiday.CalendarificHoliday;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@Data
public class CalendarificResponse {
    private CalendarificMeta meta;
    private CalendarificContent response;
}

