package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}