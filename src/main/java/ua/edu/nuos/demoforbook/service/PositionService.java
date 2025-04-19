package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Position;
import ua.edu.nuos.demoforbook.repository.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Position add(String title) {
        return positionRepository.save(new Position(title));
    }

    public void deleteById(Integer integer) {
        positionRepository.deleteById(integer);
    }

    public Optional<Position> findById(Integer integer) {
        return positionRepository.findById(integer);
    }

    public void update(Integer id, String title) {
        positionRepository.findById(id).ifPresent(position -> {
            position.setTitle(title);
            positionRepository.save(position);
        });
    }
}
