package ua.edu.nuos.demoforbook.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "street_address", length = 200)
    private String streetAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private AcademGroup group;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Student(String firstName, String lastName, LocalDate date, City city, String address, AcademGroup group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = date;
        this.city = city;
        this.streetAddress = address;
        this.group = group;
    }
}