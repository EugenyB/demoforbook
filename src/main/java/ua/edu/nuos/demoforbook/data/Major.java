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
@Table(name = "major")
public class Major {
    @Id
    @Column(name = "major_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 120)
    private String title;

    @Column(name = "code", length = 5)
    private String code;

    @OneToMany(mappedBy = "major", orphanRemoval = true)
    private Set<AcademGroup> academGroups = new LinkedHashSet<>();

    public Major(String title, String code) {
        this.title = title;
        this.code = code;
    }
}