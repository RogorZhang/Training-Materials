package com.example.springbootrestfuldemo.dao;

import com.example.springbootrestfuldemo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByAgeBetween(int from, int to);

//    @Query("SELECT * FROM student s WHERE LOWER(s.name) = lower(:name) ")
//    List<StudentEntity> findStudentsByName(@Param("name") String name);
}
