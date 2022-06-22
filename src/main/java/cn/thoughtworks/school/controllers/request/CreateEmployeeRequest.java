package cn.thoughtworks.school.controllers.request;
import lombok.Data;


@Data
public class CreateEmployeeRequest {
    private String name;
    private int age;
    private String gender;
    private int salary;
}
