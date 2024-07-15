package br.com.dwesley.employee_management.service;

import br.com.dwesley.employee_management.dto.DepartementDTO;
import br.com.dwesley.employee_management.entity.Departement;
import br.com.dwesley.employee_management.mapper.DepartementMapper;
import br.com.dwesley.employee_management.repository.DepartementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private DepartementMapper departementMapper;

    public List<DepartementDTO> getAllDepartements() {
        List<Departement> departements = departementRepository.findAll();
        return departements.stream()
            .map(departementMapper::toDTO)
            .collect(Collectors.toList());
    }

    public DepartementDTO getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id).orElse(null);
        return departementMapper.toDTO(departement);
    }

    public DepartementDTO saveDepartement(DepartementDTO departementDTO) {
        Departement departement = departementMapper.toEntity(departementDTO);
        Departement savedDepartement = departementRepository.save(departement);
        return departementMapper.toDTO(savedDepartement);
    }

    public void deleteDepartement(Long id) {
        departementRepository.deleteById(id);
    }
}



