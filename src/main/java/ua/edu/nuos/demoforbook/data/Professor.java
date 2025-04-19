package ua.edu.nuos.demoforbook.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @Column(name = "professor_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "degree", length = 100)
    private String degree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToMany(mappedBy = "professors")
    private Set<Subject> subjects = new LinkedHashSet<>();

    @OneToMany(mappedBy = "curator", orphanRemoval = true)
    private Set<AcademGroup> academGroups = new LinkedHashSet<>();

    @OneToOne(mappedBy = "head", orphanRemoval = true)
    private Department departmentHeaded;

}