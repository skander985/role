package br.com.dwesley.employee_management.mapper;

import br.com.dwesley.employee_management.dto.RoleDTO;
import br.com.dwesley.employee_management.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);

    List<RoleDTO> toDTOList(List<Role> roles);

    default List<Role> toEntityList(List<RoleDTO> roleDTOs) {
        return roleDTOs.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }
}
