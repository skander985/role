package br.com.dwesley.employee_management.service;

import br.com.dwesley.employee_management.dto.RoleDTO;
import br.com.dwesley.employee_management.entity.Role;
import br.com.dwesley.employee_management.mapper.RoleMapper;
import br.com.dwesley.employee_management.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roleMapper.toDTOList(roles);
    }

    public RoleDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role != null ? roleMapper.toDTO(role) : null;
    }

    public RoleDTO saveRole(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toDTO(savedRole);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

