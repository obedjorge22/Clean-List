package com.example.CleanList.Services;

import com.example.CleanList.Holiday.HolidayDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class NagerDateService {

    private final WebClient webClient;


        public NagerDateService(WebClient webClient) {
            this.webClient = webClient;
        }

        public boolean isHolidayOrWeekend(LocalDate date) {
            // ver se é fim de semana
            DayOfWeek dow = date.getDayOfWeek();
            if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) {
                return true;
            }

            // chamar api de feriado
            String endpoint = "/PublicHolidays/" + date.getYear() + "/AO";

            try {
                HolidayDTO[] holidays = webClient.get()
                        .uri(endpoint)
                        .retrieve()
                        .bodyToMono(HolidayDTO[].class)
                        .block(); // bloqueia para chamada síncrona

                if (holidays == null) return false;

                return Arrays.stream(holidays)
                        .anyMatch(f -> f.getDate().equals(date.toString()));

            } catch (Exception e) {
                System.out.println("Erro ao chamar API de feriados: " + e.getMessage());
                return false;
            }
    }
}
