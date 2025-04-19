package ua.edu.nuos.demoforbook.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private Set<AcademGroup> academGroups = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "head_id")
    private Professor head;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private Set<Professor> professors = new LinkedHashSet<>();

    public Department(String name) {
        this.name = name;
    }
}