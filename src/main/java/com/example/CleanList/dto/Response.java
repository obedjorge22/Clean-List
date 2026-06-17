package com.example.CleanList.dto;

import com.example.CleanList.entities.Student;
import lombok.Builder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Builder
public record Response(String status, String message, String groupName, List<Student> students) {
}
