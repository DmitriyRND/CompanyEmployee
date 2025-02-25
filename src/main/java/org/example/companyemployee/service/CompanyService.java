package org.example.companyemployee.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.companyemployee.model.Company;
import org.example.companyemployee.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not found"));
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company updateCompany(Long id, Company company) {
        Company companyById = findCompanyById(id);
      companyById.setName(company.getName());
      companyById.setAddress(company.getAddress());
      companyById.setEmployee(company.getEmployee());
        return companyRepository.save(companyById);
    }
}
