package com.example.demo_restful_api.controller;

import com.example.demo_restful_api.model.dto.DataResponse;
import com.example.demo_restful_api.model.entity.Classes;
import com.example.demo_restful_api.model.entity.Student;
import com.example.demo_restful_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<DataResponse> getStudents(){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK,studentService.getListStudents()),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertStudent(@RequestBody Student student){
        return new ResponseEntity<>(new DataResponse(HttpStatus.CREATED, studentService.insertStudent(student)),HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<DataResponse> updateStudent(@PathVariable Integer studentId, @RequestBody Student student){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK, studentService.updateStudent(studentId,student)),HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<DataResponse> getStudentById(@PathVariable Integer studentId){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK, studentService.getStudentById(studentId)),HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<DataResponse> deleteStudent(@PathVariable Integer studentId){
        return new ResponseEntity<>(new DataResponse(HttpStatus.NO_CONTENT, studentService.deleteStudent(studentId)),HttpStatus.NO_CONTENT);
    }
}
