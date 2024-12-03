package com.example.demo_restful_api.repository;

import com.example.demo_restful_api.model.entity.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {
}
