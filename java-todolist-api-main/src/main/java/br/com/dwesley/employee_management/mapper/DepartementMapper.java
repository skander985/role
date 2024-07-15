package br.com.dwesley.employee_management.mapper;

import br.com.dwesley.employee_management.dto.DepartementDTO;
import br.com.dwesley.employee_management.entity.Departement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DepartementMapper {

    DepartementMapper INSTANCE = Mappers.getMapper(DepartementMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "description", source = "description")
    DepartementDTO toDTO(Departement departement);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "description", source = "description")
    Departement toEntity(DepartementDTO departementDTO);
}





