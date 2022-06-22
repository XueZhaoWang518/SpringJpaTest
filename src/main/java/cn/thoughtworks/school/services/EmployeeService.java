package cn.thoughtworks.school.services;
import cn.thoughtworks.school.entities.Employee;
import cn.thoughtworks.school.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> getEmployees(Integer pageNum, Integer pageSize)  {
        return employeeRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }

    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public void addEmployee(String name, int age, String gender, int salary) {
        Employee employee = new Employee();
        employee.setAge(age);
        employee.setName(name);
        employee.setGender(gender);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    public boolean updateEmployee(Long employeeId, String name, int age, String gender, int salary) {
        Optional<Employee> optional = employeeRepository.findById(employeeId);
        Employee employee = null;
        if (optional.isPresent()) {
            optional.get().setName(name);
            optional.get().setAge(age);
            optional.get().setGender(gender);
            optional.get().setSalary(salary);
            employeeRepository.saveAndFlush(optional.get());
            return true;
        }
        return false;
    }

    public void deleteEmployee(Long employeeId)
    {
        employeeRepository.deleteById(employeeId);
    }


}
