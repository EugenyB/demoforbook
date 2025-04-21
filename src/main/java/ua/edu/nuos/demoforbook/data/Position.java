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
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 125)
    private String title;

    @OneToMany(mappedBy = "position")
    private Set<Professor> professors = new LinkedHashSet<>();

    public Position(String title) {
        this.title = title;
    }
}