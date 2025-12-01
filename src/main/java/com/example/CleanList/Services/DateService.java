package com.example.CleanList.Services;

import com.example.CleanList.ApiResponse.CalendarificResponse;
import com.example.CleanList.Holiday.CalendarificHoliday;
import com.example.CleanList.Holiday.HolidayDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.List;

@Service
public class DateService {
    private final WebClient webClient;
    private final String ApiKey = "mjGrvoqHQFy7oAd7OllivxfyNt2QUhht";

    public DateService(WebClient webClient) {
        this.webClient = webClient;
    }

    public CalendarificHoliday getHolidayIfExist2(LocalDate date){
        CalendarificResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/holidays")
                        .queryParam("api_key", ApiKey)
                        .queryParam("country", "AO")
                        .queryParam("year", date.getYear())
                        .build())
                .retrieve()
                .bodyToMono(CalendarificResponse.class)
                .block();

        if (response == null || response.getResponse() == null) return null;

        return response.getResponse().getHolidays().stream()
                .filter(h -> {
                    // Extrair apenas a parte yyyy-MM-dd
                    String isoDate = h.getDate().getIso();
                    LocalDate holidayDate = LocalDate.parse(isoDate.substring(0, 10));
                    return holidayDate.equals(date);
                })
                .findFirst()
                .orElse(null);
    }





    public HolidayDTO getHolidayIfExist(LocalDate date1){
        int year = date1.getYear();

        List<HolidayDTO> holidays = webClient
                .get()
                .uri("/PublicHolidays/{year}/AO",year)
                .retrieve()
                .bodyToFlux(HolidayDTO.class)
                .collectList().block();

        if (holidays == null) return null;

        return holidays.stream().filter(h -> h.getDate().equals(date1.toString())).findFirst().orElse(null);
    }

}
