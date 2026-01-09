package com.talhakoc.mapper;

import java.util.List;

import com.talhakoc.dto.employee.response.EmployeeDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.model.Employee;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface EmployeeMapper {

	@Mapping(target = "user", ignore = true)
	@Mapping(target = "id", ignore = true)
	Employee toEntity(EmployeeCreateDto employeeCreateDto);

    EmployeeDto toDto(Employee employee);

    EmployeeDetailsDto toDetailsDto(Employee employee);

	@Mapping(target = "salary", ignore = true)
	@Mapping(target = "user", ignore = true)
	void updateEmployeeFromDto(EmployeeUpdateDto employeeUpdateDto, @MappingTarget Employee employee);

	List<EmployeeDto> toDtoList(List<Employee> employees);
}
