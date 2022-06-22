package cn.thoughtworks.school.entities;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")


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
/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "company_employees",
            joinColumns = {@JoinColumn(name = "employees_employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_company_id")})
    private Company company;

    /*
    @ManyToOne
    @JoinColumn(name="company_id",insertable=false,updatable=false)
    private Company company;
    //private Long companyId;
    */
}
