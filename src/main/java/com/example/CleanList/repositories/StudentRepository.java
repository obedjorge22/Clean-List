package com.example.CleanList.repositories;

import com.example.CleanList.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByGroupId(Long order);
    List<Student> findAllByGroupId(Long groupId);


}
