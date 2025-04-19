package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Professor;
import ua.edu.nuos.demoforbook.repository.DepartmentRepository;
import ua.edu.nuos.demoforbook.repository.PositionRepository;
import ua.edu.nuos.demoforbook.repository.ProfessorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public List<Professor> findWithoutDepartments() {
        return professorRepository.findByDepartmentHeadedNull();
    }

    public void addProfessor(String firstName, String lastName, String degree, Integer departmentId, Integer positionId) {
        departmentRepository.findById(departmentId).ifPresent(department -> {
            positionRepository.findById(positionId).ifPresent(position -> {
                Professor professor = new Professor(firstName, lastName, degree, position, department);
                professorRepository.save(professor);
            });
        });
    }

    public void update(Integer id, String firstName, String lastName, String degree, Integer departmentId, Integer positionId) {
        departmentRepository.findById(departmentId).ifPresent(department -> {
           positionRepository.findById(positionId).ifPresent(position -> {
               professorRepository.findById(id).ifPresent(professor -> {
                   professor.setFirstName(firstName);
                   professor.setLastName(lastName);
                   professor.setDegree(degree);
                   professor.setPosition(position);
                   professor.setDepartment(department);
                   professorRepository.save(professor);
               });
           });
        });
    }

    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}
