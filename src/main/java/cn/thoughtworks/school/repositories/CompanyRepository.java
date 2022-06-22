package cn.thoughtworks.school.repositories;

import cn.thoughtworks.school.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@Repository
@RepositoryRestResource(collectionResourceRel = "company", path = "company")

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
