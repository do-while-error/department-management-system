package com.example.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learning.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findBydName(String dName);
}
