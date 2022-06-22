package cn.thoughtworks.school.services;

import cn.thoughtworks.school.entities.Company;
import cn.thoughtworks.school.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import cn.thoughtworks.school.repositories.CompanyRepository;


import java.util.List;
import java.util.Optional;
@Service
public class CompanyService {
    public CompanyService() {
    }

    @Autowired
    private CompanyRepository companyRepository;

    public Company getCompanyById(Long companyId) {
        Optional<Company> optional = companyRepository.findById(companyId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public void addCompany(String companyName, List<Employee> employeeList) {
        Company company = new Company();
        company.setEmployees(employeeList);
        company.setName(companyName);
        companyRepository.save(company);

    }

    public Page<Company> getCompanies(Integer pageNum, Integer pageSize) {
        Page<Company> companyList = companyRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
        return companyList;
    }

    public boolean updateCompanies(Long companyId, String companyName) {
        Optional<Company> optional = companyRepository.findById(companyId);
        Company company = null;
        if (optional.isPresent()) {
            optional.get().setName(companyName);
            companyRepository.saveAndFlush(optional.get());
            return true;
        }
        return false;
    }

    public void deleteUser(Long companyId)
    {

        companyRepository.deleteById(companyId);
    }
}






