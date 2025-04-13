package com.example.learning.serviceImpl;

import com.example.learning.domain.Department;
import com.example.learning.repository.DepartmentRepository;
import com.example.learning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicServiceImpl implements PublicService {

    @Autowired
    DepartmentRepository departmentRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public Department createDepartment(Department department) {
        department.setdPassword(passwordEncoder.encode(department.getdPassword()));
        return departmentRepository.save(department);
    }
}
