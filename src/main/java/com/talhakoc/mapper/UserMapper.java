package com.talhakoc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.user.response.UserDto;
import com.talhakoc.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDto toDto(User user);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "enabled", ignore = true)
    User toEntity(EmployeeCreateDto employeeCreateDto);

	@Mapping(target = "role", ignore = true)
	@Mapping(target = "enabled", ignore = true)
    @Mapping(target = "password" , ignore = true)
    void updateUserFromDto(EmployeeUpdateDto employeeUpdateDto, @MappingTarget User user);
}
