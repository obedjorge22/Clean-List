package com.example.CleanList.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByGroupId(Long order);
    List<Student> findAllByGroupId(Long groupId);


}
