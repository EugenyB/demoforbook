package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}