package com.example.springbootrestfuldemo.service;

import com.example.springbootrestfuldemo.entity.StudentEntity;
import com.example.springbootrestfuldemo.model.Student;

import java.util.List;

public interface StudentService {

    Student findById(long id);
    List<Student> findAllStudents();
    List<Student> findStudentsByAgeBetween(int from, int to);
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudentById(long id);

}
