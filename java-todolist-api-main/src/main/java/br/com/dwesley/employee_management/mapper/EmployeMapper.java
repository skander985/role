package br.com.dwesley.employee_management.mapper;

import br.com.dwesley.employee_management.dto.EmployeDTO;
import br.com.dwesley.employee_management.entity.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface EmployeMapper {

    @Mapping(source = "departement.id", target = "departementId")
    @Mapping(source = "role.id", target = "roleId")
    EmployeDTO toDTO(Employe employe);

    @Mapping(source = "departementId", target = "departement.id")
    @Mapping(source = "roleId", target = "role.id")
    Employe toEntity(EmployeDTO employeDTO);
}

