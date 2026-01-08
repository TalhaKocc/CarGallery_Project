package com.talhakoc.controller;

import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.model.Employee;
import com.talhakoc.repository.EmployeeRepository;
import com.talhakoc.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> listAll(){
        return ResponseEntity.ok(employeeService.listAll());
    }



}
