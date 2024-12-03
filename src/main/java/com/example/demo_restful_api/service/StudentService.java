package com.example.demo_restful_api.service;

import com.example.demo_restful_api.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getListStudents();
    Student insertStudent(Student student);
    Student updateStudent(Integer stuId, Student student);
    Student deleteStudent(Integer stuId);
    Student getStudentById(Integer stuId);
}
