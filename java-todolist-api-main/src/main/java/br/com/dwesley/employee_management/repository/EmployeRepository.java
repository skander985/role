package br.com.dwesley.employee_management.repository;

import br.com.dwesley.employee_management.entity.Employe;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}



