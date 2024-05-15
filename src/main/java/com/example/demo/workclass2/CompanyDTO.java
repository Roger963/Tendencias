package com.example.demo.workclass2;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    @Size(min = 5, max = 60, message = "O nome deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo Obrigatório")
    private String name;
    @Size(min = 5, max = 60, message = "O nome deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo Obrigatório")
    private String address;
    @Size(min = 5, max = 60, message = "O nome deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo Obrigatório")
    private String ruc;

    private List <CompanyDTO> companies = new ArrayList<>();

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.address = company.getAddress();
        this.ruc = company.getRuc();
    }

    
}
