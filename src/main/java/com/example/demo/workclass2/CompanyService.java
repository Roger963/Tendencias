package com.example.demo.workclass2;



import jakarta.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class CompanyService {
    public CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Transactional(readOnly = true)
    public Page<CompanyDTO> findAllPaged(Pageable pageable) {
        Page<Company> companyPage = companyRepository.findAll(pageable);
        return companyPage.map(CompanyDTO::new);
    }
    @Transactional(readOnly = true)
    public CompanyDTO findById(Long id) {
        Optional<Company> entity = companyRepository.findById(id);
        return entity.map(CompanyDTO::new).orElse(null);
    }
    @Transactional
    public CompanyDTO insert(CompanyDTO dto){
        Company entity = new Company();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setRuc(dto.getRuc());
        entity = companyRepository.save(entity);
        return new CompanyDTO(entity);
    }
    @Transactional
    public CompanyDTO update(Long id, CompanyDTO dto){
        try {
            Company entity = companyRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity.setAddress(dto.getAddress());
            entity.setRuc(dto.getRuc());
            entity = companyRepository.save(entity);
            return new CompanyDTO(entity);
            } catch (EntityNotFoundException e) {
                throw new EntityNotFoundException("Company not found for id: " + id);
            }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            companyRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotFoundException("Company not found for id: " + id);
        }
    }
}
