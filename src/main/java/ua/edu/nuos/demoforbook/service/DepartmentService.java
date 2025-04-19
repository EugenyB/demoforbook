package ua.edu.nuos.demoforbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Department;
import ua.edu.nuos.demoforbook.repository.DepartmentRepository;
import ua.edu.nuos.demoforbook.repository.ProfessorRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public void setHead(Integer did, Integer hid) {
        departmentRepository.findById(did).ifPresent(department -> {
            professorRepository.findById(hid).ifPresent(professor -> {
                department.setHead(professor);
                departmentRepository.save(department);
            });
        });
    }
}
