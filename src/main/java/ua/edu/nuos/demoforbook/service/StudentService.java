package ua.edu.nuos.demoforbook.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.nuos.demoforbook.data.Student;
import ua.edu.nuos.demoforbook.repository.AcademGroupRepository;
import ua.edu.nuos.demoforbook.repository.CityRepository;
import ua.edu.nuos.demoforbook.repository.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CityRepository cityRepository;
    private final AcademGroupRepository academGroupRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(
            String firstName,
            String lastName,
            String birthdayStr,
            Integer cityId,
            String address,
            Integer groupId) {
        cityRepository.findById(cityId).ifPresent(city -> {
            academGroupRepository.findById(groupId).ifPresent(group -> {
                LocalDate date = LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE);
                studentRepository.save(new Student(firstName, lastName, date, city, address, group));
            });
        });

    }

    public void updateStudent(
            Integer id,
            String firstName,
            String lastName,
            String birthdayStr,
            Integer cityId,
            String address,
            Integer groupId) {
        cityRepository.findById(cityId).ifPresent(city -> {
            academGroupRepository.findById(groupId).ifPresent(group -> {
                studentRepository.findById(id).ifPresent(student -> {
                    LocalDate date = LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE);
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setBirthday(date);
                    student.setStreetAddress(address);
                    student.setCity(city);
                    student.setGroup(group);
                    studentRepository.save(student);
                });
            });
        });
    }
}
