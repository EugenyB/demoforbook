package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Professor;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByDepartmentHeadedNull();
}