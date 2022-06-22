package cn.thoughtworks.school.controllers.response;
import cn.thoughtworks.school.entities.Company;
import lombok.Data;


@Data
public class CreateCompanyResponse {


    private Long companyId;
    private String name;
    private int employeesNumber;

    public CreateCompanyResponse(Company company) {
        this.companyId = company.getCompanyId();
        this.name = company.getName();
        this.employeesNumber = company.getEmployeesNumber();
    }

}
