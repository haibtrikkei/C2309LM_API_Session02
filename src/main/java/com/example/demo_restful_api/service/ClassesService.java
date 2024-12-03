package com.example.demo_restful_api.service;

import com.example.demo_restful_api.model.entity.Classes;

import java.util.List;

public interface ClassesService {
    List<Classes> getListClasses();
    Classes insertClass(Classes classes);
    Classes updateClass(String classId, Classes classes);
    Classes deleteClass(String classId);
    Classes getClassByIs(String classId);
}
