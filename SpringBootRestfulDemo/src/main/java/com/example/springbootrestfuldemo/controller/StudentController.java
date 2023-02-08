package com.example.springbootrestfuldemo.controller;

import com.example.springbootrestfuldemo.exception.AgeNotValidException;
import com.example.springbootrestfuldemo.exception.StudentNotFoundException;
import com.example.springbootrestfuldemo.model.ErrorResponse;
import com.example.springbootrestfuldemo.model.ResponseMessage;
import com.example.springbootrestfuldemo.model.Student;
import com.example.springbootrestfuldemo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@ResponseBody
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student doesn't exist");
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

//    @GetMapping("/students")
//    public ResponseEntity<?> getAllStudents() {
//        List<Student> students = studentService.findAllStudents();
//        return new ResponseEntity<>(students, HttpStatus.valueOf(200));
//    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudentsByAgeBetween(@RequestParam(required = false, defaultValue = "0") Integer from,
                                                     @RequestParam(required = false, defaultValue = "200") Integer to) {
        if (from < 0) {
            throw new AgeNotValidException("Age should be at least 0");
        }
        logger.info("get students by age between " + from + " " + to);
        List<Student> students = studentService.findStudentsByAgeBetween(from, to);
        return new ResponseEntity<>(students, HttpStatus.valueOf(200));
    }

    @PostMapping("/students")
    public ResponseEntity<ResponseMessage> createStudent(@Validated @RequestBody Student student) {
//        logger.debug("create studnet", student);
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(new ResponseMessage("student has been created", savedStudent), HttpStatus.CREATED);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @Validated @RequestBody Student student) {
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            throw new StudentNotFoundException("Student doesn't exist");
        }

        currentStudent.setName(student.getName());
        currentStudent.setAge(student.getAge());
        currentStudent.setEmail(student.getEmail());
        studentService.updateStudent(currentStudent);
        return new ResponseEntity<>(currentStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<ResponseMessage> deleteStudent(@PathVariable("id") long id) {
        Student student = studentService.findById(id);
        if (student == null) {
            throw new StudentNotFoundException("Student doesn't exist");
        }
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(new ResponseMessage("student has been deleted", student), HttpStatus.OK);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerStudentNotFound(Exception ex) {
        logger.error("Can't find student");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
