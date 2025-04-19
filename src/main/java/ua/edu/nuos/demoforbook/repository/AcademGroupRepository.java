package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.AcademGroup;

public interface AcademGroupRepository extends JpaRepository<AcademGroup, Integer> {
}