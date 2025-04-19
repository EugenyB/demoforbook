package ua.edu.nuos.demoforbook.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "semestr")
    private Integer semestr;

    @ManyToMany
    @JoinTable(name = "subject_professor",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private Set<Professor> professors = new LinkedHashSet<>();

}