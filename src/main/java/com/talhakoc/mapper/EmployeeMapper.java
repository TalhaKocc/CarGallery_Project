package com.talhakoc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.model.Employee;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface EmployeeMapper {

	@Mapping(target = "user", ignore = true)
	@Mapping(target = "id", ignore = true)
	Employee toEmployee(EmployeeCreateDto employeeCreateDto);

	@Mapping(target = "salary", ignore = true)
	@Mapping(target = "user", ignore = true)
	// @MappingTaget ile olan verinin üzerine yazdırma işlemi yapılır o yüzden kullanılır
	void updateEmployeeFromDto(EmployeeUpdateDto employeeUpdateDto, @MappingTarget Employee employee);
}
