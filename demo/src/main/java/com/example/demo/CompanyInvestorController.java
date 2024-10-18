package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Importação adicionada
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException; // Importação adicionada

@RestController
@RequestMapping("/api/companyinvestors")
public class CompanyInvestorController {

    @Autowired
    private CompanyInvestorRepository companyInvestorRepository;

    // Recupera todos os CompanyInvestors ou filtra por parte do nome
    @GetMapping
    public Iterable<CompanyInvestor> getCompanyInvestors(@RequestParam Optional<String> namePart) {
        if (namePart.isPresent()) {
            return companyInvestorRepository.findCompanyInvestorsByNamePart(namePart.get());
        }
        return companyInvestorRepository.findAll();
    }

    // Recupera um CompanyInvestor específico pelo ID
    @GetMapping("/{id}")
    public CompanyInvestor getCompanyInvestor(@PathVariable Long id) {
        return companyInvestorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "CompanyInvestor não encontrado com id " + id));
    }

    // Cria um novo CompanyInvestor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyInvestor createCompanyInvestor(@RequestBody CompanyInvestor companyInvestor) {
        return companyInvestorRepository.save(companyInvestor);
    }

    // Atualiza os dados de um CompanyInvestor pelo ID
    @PutMapping("/{id}")
    public CompanyInvestor updateCompanyInvestor(@RequestBody CompanyInvestor companyInvestorRequest, @PathVariable Long id) {
        if (!companyInvestorRequest.getId().equals(id)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, 
                    "O ID no corpo da requisição não corresponde ao ID da URL");
        }

        return companyInvestorRepository.findById(id)
                .map(companyInvestor -> {
                    companyInvestor.setName(companyInvestorRequest.getName());
                    companyInvestor.setCompanyType(companyInvestorRequest.getCompanyType());
                    companyInvestor.setLei(companyInvestorRequest.getLei());
                    // Atualize outros campos conforme necessário
                    return companyInvestorRepository.save(companyInvestor);
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "CompanyInvestor não encontrado com id " + id));
    }

    // Deleta um CompanyInvestor pelo ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompanyInvestor(@PathVariable Long id) {
        if (!companyInvestorRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, 
                    "CompanyInvestor não encontrado com id " + id);
        }
        companyInvestorRepository.deleteById(id);
    }
}
