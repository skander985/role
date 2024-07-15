package br.com.dwesley.employee_management.controller;

import br.com.dwesley.employee_management.dto.EmployeDTO;
import br.com.dwesley.employee_management.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<EmployeDTO> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @GetMapping("/{id}")
    public EmployeDTO getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping
    public EmployeDTO createEmploye(@RequestBody EmployeDTO employeDTO) {
        return employeService.saveEmploye(employeDTO);
    }

    @PutMapping("/{id}")
    public EmployeDTO updateEmploye(@PathVariable Long id, @RequestBody EmployeDTO employeDetails) {
        EmployeDTO employeDTO = employeService.getEmployeById(id);
        if (employeDTO != null) {
            employeDTO.setNom(employeDetails.getNom());
            employeDTO.setPrénom(employeDetails.getPrénom());
            employeDTO.setAdresse(employeDetails.getAdresse());
            employeDTO.setContact(employeDetails.getContact());
            employeDTO.setNuméroEmployé(employeDetails.getNuméroEmployé());
            employeDTO.setDateEmbauche(employeDetails.getDateEmbauche());
            employeDTO.setDepartementId(employeDetails.getDepartementId());
            employeDTO.setRoleId(employeDetails.getRoleId());
            return employeService.saveEmploye(employeDTO);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }
}


