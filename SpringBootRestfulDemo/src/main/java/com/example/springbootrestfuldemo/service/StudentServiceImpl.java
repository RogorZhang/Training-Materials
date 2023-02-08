package com.example.springbootrestfuldemo.service;

import com.example.springbootrestfuldemo.dao.StudentRepository;
import com.example.springbootrestfuldemo.entity.StudentEntity;
import com.example.springbootrestfuldemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.example.springbootrestfuldemo.util.StudentEntityVoConverter.convertEntityToVo;
import static com.example.springbootrestfuldemo.util.StudentEntityVoConverter.convertVoToEntity;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepo;
    @Override
    public Student findById(long id) {
        StudentEntity studentEntity = studentRepo.findById(id).orElse(null);
        return convertEntityToVo(studentEntity);
    }

    @Override
    public List<Student> findAllStudents() {
        List<StudentEntity> students = studentRepo.findAll();
        return students.stream().map(e -> convertEntityToVo(e)).collect(Collectors.toList());
    }

    @Override
    public List<Student> findStudentsByAgeBetween(int from, int to) {
        List<StudentEntity> students = studentRepo.findByAgeBetween(from, to);
        return students.stream().map(e -> convertEntityToVo(e)).collect(Collectors.toList());
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntity = studentRepo.saveAndFlush(convertVoToEntity(student));
        return convertEntityToVo(studentEntity);
    }

    @Override
    public Student updateStudent(Student student) {
        StudentEntity studentEntity = studentRepo.saveAndFlush(convertVoToEntity(student));
        return convertEntityToVo(studentEntity);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepo.deleteById(id);
    }


}
