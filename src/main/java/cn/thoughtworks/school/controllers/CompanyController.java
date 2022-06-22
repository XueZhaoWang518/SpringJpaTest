package cn.thoughtworks.school.controllers;

import cn.thoughtworks.school.controllers.request.CreateCompanyRequest;
import cn.thoughtworks.school.controllers.response.CreateCompanyResponse;
import cn.thoughtworks.school.services.CompanyService;
import cn.thoughtworks.school.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/{companyId}")
    public ResponseEntity<CreateCompanyResponse> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(new CreateCompanyResponse(companyService.getCompanyById(companyId)));
    }

    @PostMapping()
    public void addCompany(@RequestBody CreateCompanyRequest request) {
        companyService.addCompany(request.getCompanyName(), request.getEmployees());
    }

    @GetMapping()
    public ResponseEntity<Page<CreateCompanyResponse>> pageQuery(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Company> companies = companyService.getCompanies(pageNum, pageSize);
        Page<CreateCompanyResponse> map = companies.map(it -> new CreateCompanyResponse(it));
        return ResponseEntity.ok(map);
    }


    @PutMapping("/{companyId}")
    public void updateCompanies(@PathVariable Long companyId, @RequestBody CreateCompanyRequest request) {
        companyService.updateCompanies(companyId, request.getCompanyName());

    }

    @DeleteMapping("/{companyId}")
    public void deletCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
    }
}


