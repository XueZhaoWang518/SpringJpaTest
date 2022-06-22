package cn.thoughtworks.school.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data


public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "gender", nullable = false, length=200)
    private String gender;
    @Column(name = "salary", nullable = false)
    private int salary;

}
