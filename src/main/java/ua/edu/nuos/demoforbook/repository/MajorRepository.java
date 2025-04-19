package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Major;

public interface MajorRepository extends JpaRepository<Major, Integer> {
}