package com.example.learning.serviceImpl;

import com.example.learning.domain.Department;
import com.example.learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DepartmentLoginImpl implements UserDetailsService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Department department = departmentRepository.findBydName(username);
        System.out.println();
        if(department != null){
            return User.builder().username(department.getdName()).password(department.getdPassword()).build();
        }
        throw new UsernameNotFoundException("Department Not found...");
    }
}
