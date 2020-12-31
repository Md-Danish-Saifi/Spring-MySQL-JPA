package com.naviya.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naviya.demo.Model.Employee;
public interface Repository extends JpaRepository<Employee, Integer>{
}
