package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Professor;
import ua.edu.nuos.demoforbook.repository.ProfessorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public List<Professor> findWithoutDepartments() {
        return professorRepository.findByDepartmentHeadedNull();
    }
}
