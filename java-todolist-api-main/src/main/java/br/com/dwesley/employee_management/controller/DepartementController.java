package br.com.dwesley.employee_management.controller;

import br.com.dwesley.employee_management.dto.DepartementDTO;
import br.com.dwesley.employee_management.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public List<DepartementDTO> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public DepartementDTO getDepartementById(@PathVariable Long id) {
        return departementService.getDepartementById(id);
    }

    @PostMapping
    public DepartementDTO createDepartement(@RequestBody DepartementDTO departementDTO) {
        return departementService.saveDepartement(departementDTO);
    }

    @PutMapping("/{id}")
    public DepartementDTO updateDepartement(@PathVariable Long id, @RequestBody DepartementDTO departementDetails) {
        DepartementDTO departementDTO = departementService.getDepartementById(id);
        if (departementDTO != null) {
            departementDTO.setNom(departementDetails.getNom());
            departementDTO.setDescription(departementDetails.getDescription());
            return departementService.saveDepartement(departementDTO);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDepartement(@PathVariable Long id) {
        departementService.deleteDepartement(id);
    }
}


