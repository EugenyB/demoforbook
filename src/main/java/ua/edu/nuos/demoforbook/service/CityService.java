package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.City;
import ua.edu.nuos.demoforbook.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CityService {
    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City add(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> findById(Integer integer) {
        return cityRepository.findById(integer);
    }

    public void deleteById(Integer integer) {
        cityRepository.deleteById(integer);
    }

    public void updateCity(Integer id, String name) {
        cityRepository.findById(id).ifPresent(city -> {
            city.setName(name);
            cityRepository.save(city);
        });
    }
}
