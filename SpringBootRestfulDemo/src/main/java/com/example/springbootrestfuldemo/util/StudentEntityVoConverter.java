package com.example.springbootrestfuldemo.util;

import com.example.springbootrestfuldemo.entity.StudentEntity;
import com.example.springbootrestfuldemo.model.Student;

public class StudentEntityVoConverter {

    public static Student convertEntityToVo(StudentEntity entity) {
        if (entity == null) return null;

        Student student = new Student();
        student.setId(entity.getId());
        student.setName(entity.getName());
        student.setAge(entity.getAge());
        student.setEmail(entity.getEmail());
        return student;
    }

    public static StudentEntity convertVoToEntity(Student student) {
        if (student == null) return null;

       return new StudentEntity(student.getId(), student.getName(), student.getAge(), student.getEmail());
    }


}
