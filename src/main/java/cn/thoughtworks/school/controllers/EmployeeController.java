package cn.thoughtworks.school.controllers;

import cn.thoughtworks.school.controllers.response.CreateCompanyResponse;
import cn.thoughtworks.school.entities.Employee;
import cn.thoughtworks.school.repositories.EmployeeRepository;
import cn.thoughtworks.school.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import cn.thoughtworks.school.controllers.request.CreateEmployeeRequest;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<Page<Employee>> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                 @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Employee> employees = employeeService.getEmployees(pageNum, pageSize);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("")
    public void addEmployee(@RequestBody CreateEmployeeRequest employee) {
        employeeService.addEmployee(employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
    }

    @PutMapping("/{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestBody CreateEmployeeRequest employee) {
        employeeService.updateEmployee(employeeId, employee.getName(), employee.getAge(), employee.getGender(), employee.getSalary());
    }

    @DeleteMapping("/{employeeId}")
    public void deleteUser(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}


