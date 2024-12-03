package com.example.demo_restful_api.controller;

import com.example.demo_restful_api.model.dto.DataResponse;
import com.example.demo_restful_api.model.entity.Classes;
import com.example.demo_restful_api.model.entity.Student;
import com.example.demo_restful_api.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping
    public ResponseEntity<DataResponse> getClasses(){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK,classesService.getListClasses()),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> insertClasses(@RequestBody Classes classes){
        return new ResponseEntity<>(new DataResponse(HttpStatus.CREATED, classesService.insertClass(classes)),HttpStatus.CREATED);
    }

    @PutMapping("/{classId}")
    public ResponseEntity<DataResponse> updateClasses(@PathVariable String classId, @RequestBody Classes classes){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK, classesService.updateClass(classId,classes)),HttpStatus.OK);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<DataResponse> getClassById(@PathVariable String classId){
        return new ResponseEntity<>(new DataResponse(HttpStatus.OK, classesService.getClassByIs(classId)),HttpStatus.OK);
    }

    @DeleteMapping("/{classId}")
    public ResponseEntity<DataResponse> deleteClasses(@PathVariable String classId){
        return new ResponseEntity<>(new DataResponse(HttpStatus.NO_CONTENT, classesService.deleteClass(classId)),HttpStatus.NO_CONTENT);
    }
}
