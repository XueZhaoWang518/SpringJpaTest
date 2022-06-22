package cn.thoughtworks.school.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "companyId"
)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long companyId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "employee_number", nullable = false)
    private int employeesNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employees;
}
