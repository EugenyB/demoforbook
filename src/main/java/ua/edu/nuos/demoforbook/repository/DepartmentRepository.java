package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}