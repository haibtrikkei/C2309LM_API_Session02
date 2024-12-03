package com.example.demo_restful_api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer stuId;
    @Column(name = "full_name",length = 50)
    private String fullName;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "address",length = 200)
    private String address;

    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "class_id")
    private Classes classes;

}
