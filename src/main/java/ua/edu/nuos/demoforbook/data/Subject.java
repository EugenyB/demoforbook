package ua.edu.nuos.demoforbook.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    @Column(name = "description", length = 200)
    private String description;

    @ManyToMany
    @JoinTable(name = "subject_professor",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private Set<Professor> professors = new LinkedHashSet<>();

    public Subject(String title, String description, Integer semester, Integer duration) {
        this.title = title;
        this.description = description;
        this.semestr = semester;
        this.duration = duration;
    }
}