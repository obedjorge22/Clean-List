package com.example.CleanList.repositories;

import com.example.CleanList.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByOrder(@Param("order") long order);
}
