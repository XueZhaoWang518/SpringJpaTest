package cn.thoughtworks.school.repositories;

import cn.thoughtworks.school.entities.Company;
import cn.thoughtworks.school.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}


