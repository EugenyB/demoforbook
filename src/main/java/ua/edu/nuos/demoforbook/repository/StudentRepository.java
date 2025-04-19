package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}