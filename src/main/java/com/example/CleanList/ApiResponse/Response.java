package com.example.CleanList.ApiResponse;

import com.example.CleanList.Student.Student;

import java.util.List;

public record Response(String status, String message, String groupName, List<Student> students) {
}
