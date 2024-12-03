package com.example.demo_restful_api.service.impl;

import com.example.demo_restful_api.model.entity.Classes;
import com.example.demo_restful_api.repository.ClassesRepository;
import com.example.demo_restful_api.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesRepository classesRepository;

    @Override
    public List<Classes> getListClasses() {
        return classesRepository.findAll();
    }

    @Override
    public Classes insertClass(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public Classes updateClass(String classId, Classes classes) {
        classesRepository.findById(classId).orElseThrow(()-> new NoSuchElementException("Classes not found!"));
        classes.setClassId(classId);
        return classesRepository.save(classes);
    }

    @Override
    public Classes deleteClass(String classId) {
        Classes classes = classesRepository.findById(classId).orElseThrow(() -> new NoSuchElementException("Classes not found!"));
        classesRepository.delete(classes);
        return classes;
    }

    @Override
    public Classes getClassByIs(String classId) {
        return classesRepository.findById(classId).orElseThrow(()-> new NoSuchElementException("Classes not found!"));
    }
}
