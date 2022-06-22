package cn.thoughtworks.school.controllers.request;


import cn.thoughtworks.school.entities.Employee;
import lombok.Data;
import java.util.List;


@Data
public class CreateCompanyRequest {
    private String companyName;
    private List<Employee> employees;

}
