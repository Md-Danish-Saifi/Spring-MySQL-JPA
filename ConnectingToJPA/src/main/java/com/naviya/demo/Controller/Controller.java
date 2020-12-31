package com.naviya.demo.Controller;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.naviya.demo.Model.Employee;
import com.naviya.demo.Repository.Repository;
import com.naviya.demo.Service.Service;

@RestController
public class Controller {

	@Autowired
	Repository repo;
	
	@Autowired
	Service service;
	
	@PostMapping("/add")
	@CrossOrigin
	@Transactional
	public String saveEmployee(@RequestBody Employee emp)
	{
		service.saveEmployee(emp);	
		return "Employee "+emp.getName()+" inserted Successfully";
	}
	
	@GetMapping("/get")
	@CrossOrigin
	public Iterable<Employee> getEmployeeDetails()
	{
		return repo.findAll();
	}
	
	@GetMapping("/delete/{id}")
	@CrossOrigin
	@Transactional
	public Iterable<Employee> removeEmp(@PathVariable int id)
	{
		repo.deleteById(id);
		return repo.findAll();
	}
	
	@GetMapping("/find/{id}")
	@CrossOrigin
	public Optional<Employee> findById(@PathVariable int id)
	{
		return repo.findById(id);
	}
}
