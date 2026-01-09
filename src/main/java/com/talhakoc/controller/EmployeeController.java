package com.talhakoc.controller;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.dto.user.response.UserDto;
import com.talhakoc.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> listAll(){
        return ResponseEntity.ok(employeeService.listAll());
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@Valid @RequestBody EmployeeCreateDto employeeCreateDto){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeCreateDto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@Valid @RequestBody EmployeeUpdateDto employeeUpdateDto){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeUpdateDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
