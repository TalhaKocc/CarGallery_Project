package com.talhakoc.dto.employee.response;

import java.math.BigDecimal;

import com.talhakoc.dto.user.response.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;
	
	private UserDto user;
	
	private BigDecimal salary;
	
	private String phoneNumber;
	
}


/*

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    // CREATE → EmployeeCreateDto → Employee
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true) // service içinde set edilecek
    Employee toEntity(EmployeeCreateDto dto);

    // UPDATE → EmployeeUpdateDto → Employee
    @Mapping(target = "user", ignore = true) // user güncellemesini service yapar
    Employee toEntity(EmployeeUpdateDto dto);

    // RESPONSE → Employee → EmployeeDto
    @Mapping(target = "fullName", source = "user.fullName")
    @Mapping(target = "email", source = "user.email")
    EmployeeDto toDto(Employee employee);

    // Listeleme için (opsiyonel)
    List<EmployeeDto> toDtoList(List<Employee> employees);
}


*/