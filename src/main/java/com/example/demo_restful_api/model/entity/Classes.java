package com.example.demo_restful_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classes {
    @Id
    @Column(name = "class_id")
    private String classId;
    @Column(name = "class_name",length = 100,nullable = false,unique = true)
    private String className;

    @OneToMany(mappedBy = "classes")
    @JsonIgnore
    private List<Student> students;
}
