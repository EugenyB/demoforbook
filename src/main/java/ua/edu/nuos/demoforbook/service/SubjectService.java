package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Subject;
import ua.edu.nuos.demoforbook.repository.SubjectRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository repository;

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public void add(String title, String description, Integer semester, Integer duration) {
        repository.save(new Subject(title, description, semester, duration));
    }

    public void update(Integer subjectId, String title, String description, Integer semester, Integer duration) {
        repository.findById(subjectId).ifPresent(subject -> {
            subject.setTitle(title);
            subject.setDescription(description);
            subject.setDuration(duration);
            subject.setSemestr(semester);
            repository.save(subject);
        });
    }
}
