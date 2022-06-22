package cn.thoughtworks.school.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@Data

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "employee_number", nullable = false)
    private int employeesNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;
}
