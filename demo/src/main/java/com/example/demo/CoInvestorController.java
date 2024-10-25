package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoInvestorController {

    @Autowired
    private CoInvestorRepository coInvestorRepository;

    // Retorna todos os co-investidores
    @GetMapping("/api/coinvestors")
    public List<CoInvestor> getAllCoInvestors() {
        return coInvestorRepository.findAll();
    }

    // Retorna um co-investidor pelo ID
    @GetMapping("/api/coinvestors/{id}")
    public ResponseEntity<CoInvestor> getCoInvestorById(@PathVariable Long id) {
        Optional<CoInvestor> coInvestor = coInvestorRepository.findById(id);
        return coInvestor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Busca co-investidores por parte do nome
    @GetMapping("/api/coinvestors/search")
    public List<CoInvestor> searchCoInvestorsByName(@RequestParam("name") String namePart) {
        return coInvestorRepository.findCompanyCoInvestorsByNamePart(namePart);
    }

    // Cria um novo co-investidor
    @PostMapping("/api/coinvestors")
    public CoInvestor createCoInvestor(@RequestBody CoInvestor coInvestor) {
        return coInvestorRepository.save(coInvestor);
    }

    // Atualiza um co-investidor existente
    @PutMapping("/api/coinvestors/{id}")
    public ResponseEntity<CoInvestor> updateCoInvestor(@PathVariable Long id, @RequestBody CoInvestor coInvestorDetails) {
        Optional<CoInvestor> coInvestor = coInvestorRepository.findById(id);
        if (coInvestor.isPresent()) {
            CoInvestor updatedCoInvestor = coInvestor.get();
            updatedCoInvestor.setCoInvestorType(coInvestorDetails.getCoInvestorType());
            updatedCoInvestor.setName(coInvestorDetails.getName()); // Atualiza o nome, se necessário
            coInvestorRepository.save(updatedCoInvestor);
            return ResponseEntity.ok(updatedCoInvestor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deleta um co-investidor pelo ID
    @DeleteMapping("/api/coinvestors/{id}")
    public ResponseEntity<Void> deleteCoInvestor(@PathVariable Long id) {
        Optional<CoInvestor> coInvestor = coInvestorRepository.findById(id);
        if (coInvestor.isPresent()) {
            coInvestorRepository.delete(coInvestor.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
