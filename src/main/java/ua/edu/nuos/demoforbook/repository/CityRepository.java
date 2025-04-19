package ua.edu.nuos.demoforbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.nuos.demoforbook.data.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}