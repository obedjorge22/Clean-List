package com.example.CleanList.Services;

import com.example.CleanList.ApiResponse.Response;
import com.example.CleanList.Group.Group;
import com.example.CleanList.Group.GroupRepository;
import com.example.CleanList.Holiday.CalendarificHoliday;
import com.example.CleanList.Holiday.HolidayDTO;
import com.example.CleanList.Student.Student;
import com.example.CleanList.Student.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class CleanDayService {

    private final DateService dateService;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public Object checkDay(LocalDate date){

        CalendarificHoliday holiday = dateService.getHolidayIfExist2(date);

        if (holiday != null) {
            return new Response(
                    "feriado",
                    holiday.getName(),
                    null,
                    null
            );
        }

        DayOfWeek dayOfWeek = date.getDayOfWeek() ;
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY){
            return new Response("fim de semana", dayOfWeek.name(), null,null);
        }

        long numeroDoDia = date.getDayOfMonth(); // 1 a 31
        long totalGrupos = groupRepository.count(); // 11 grupos
        long ordemDoGrupo = ((numeroDoDia - 1) % totalGrupos) + 1; // de volta ao intervalo 1..11
        System.out.println("Dia do mês: " + numeroDoDia + ", Ordem do grupo ..........: " + ordemDoGrupo);

        Group group = groupRepository.findByOrder(ordemDoGrupo);
        if (group == null){
            return new Response("sem_grupo", "Nenhum grupo definido para hoje", null, null);
        }


        List<Student> students = studentRepository.findAllByGroupId(group.getId_group());


        return new Response("dia de limpeza", null,group.getName(),students);

    }



}
