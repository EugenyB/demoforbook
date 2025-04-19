package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Major;
import ua.edu.nuos.demoforbook.repository.MajorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;

    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    public Major add(String title, String code) {
        return majorRepository.save(new Major(title, code));
    }

    public void deleteById(Integer integer) {
        majorRepository.deleteById(integer);
    }

    public Optional<Major> findById(Integer integer) {
        return majorRepository.findById(integer);
    }

    public void update(Integer id, String title, String code) {
        majorRepository.findById(id).ifPresent(major -> {
            major.setTitle(title);
            major.setCode(code);
            majorRepository.save(major);
        });
    }
}
