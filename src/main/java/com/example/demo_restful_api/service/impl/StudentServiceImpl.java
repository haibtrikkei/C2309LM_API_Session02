package com.example.demo_restful_api.service.impl;

import com.example.demo_restful_api.model.entity.Student;
import com.example.demo_restful_api.repository.StudentRepository;
import com.example.demo_restful_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getListStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Integer stuId, Student student) {
        studentRepository.findById(stuId).orElseThrow(()->new NoSuchElementException("Student not found!"));
        student.setStuId(stuId);
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Integer stuId) {
        Student student = studentRepository.findById(stuId).orElseThrow(() -> new NoSuchElementException("Student not found!"));
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student getStudentById(Integer stuId) {
        return studentRepository.findById(stuId).orElseThrow(()->new NoSuchElementException("Student not found!"));
    }
}
