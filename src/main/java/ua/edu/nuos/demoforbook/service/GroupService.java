package ua.edu.nuos.demoforbook.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.nuos.demoforbook.data.AcademGroup;
import ua.edu.nuos.demoforbook.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private final AcademGroupRepository groupRepository;
    private final MajorRepository majorRepository;
    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;

    public List<AcademGroup> findAll() {
        return groupRepository.findAll();
    }

    public Optional<AcademGroup> findById(Integer id) {
        return groupRepository.findById(id);
    }

    public void addGroup(String name, Integer majorId, Integer deptId, Integer profId) {
        majorRepository.findById(majorId).ifPresent(major -> {
           professorRepository.findById(profId).ifPresent(professor -> {
                departmentRepository.findById(deptId).ifPresent(department -> {
                   groupRepository.save(new AcademGroup(name, major, professor, department));
                });
           });
        });
    }

    public void deleteById(Integer id) {
        groupRepository.deleteById(id);
    }

    public void update(Integer id, String name, Integer majorId, Integer deptId, Integer profId) {
        majorRepository.findById(majorId).ifPresent(major -> {
           departmentRepository.findById(deptId).ifPresent(department -> {
              professorRepository.findById(profId).ifPresent(professor -> {
                groupRepository.findById(id).ifPresent(group -> {
                    group.setName(name);
                    group.setCurator(professor);
                    group.setDepartment(department);
                    group.setMajor(major);
                    groupRepository.save(group);
                });
              });
           });
        });
    }
}
