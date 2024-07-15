package br.com.dwesley.employee_management.service;

import br.com.dwesley.employee_management.dto.EmployeDTO;
import br.com.dwesley.employee_management.entity.Employe;
import br.com.dwesley.employee_management.mapper.EmployeMapper;
import br.com.dwesley.employee_management.repository.EmployeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeService {

    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    @Autowired
    public EmployeService(EmployeRepository employeRepository, EmployeMapper employeMapper) {
        this.employeRepository = employeRepository;
        this.employeMapper = employeMapper;
    }

    public List<EmployeDTO> getAllEmployes() {
        List<Employe> employes = employeRepository.findAll();
        return employes.stream()
            .map(employeMapper::toDTO)
            .collect(Collectors.toList());
    }

    public EmployeDTO getEmployeById(Long id) {
        Employe employe = employeRepository.findById(id).orElse(null);
        return employeMapper.toDTO(employe);
    }

    public EmployeDTO saveEmploye(EmployeDTO employeDTO) {
        Employe employe = employeMapper.toEntity(employeDTO);
        Employe savedEmploye = employeRepository.save(employe);
        return employeMapper.toDTO(savedEmploye);
    }

    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}


