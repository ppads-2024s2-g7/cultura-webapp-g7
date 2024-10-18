package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-structures")
public class FundStructureController {

    @Autowired
    private FundStructureRepository fundStructureRepository;

    // Criar nova FundStructure
    @PostMapping
    public FundStructure createFundStructure(@RequestBody FundStructure fundStructure) {
        return fundStructureRepository.save(fundStructure);
    }

    // Listar todas as FundStructures
    @GetMapping
    public List<FundStructure> getAllFundStructures() {
        return fundStructureRepository.findAll();
    }

    // Obter FundStructure por ID
    @GetMapping("/{id}")
    public ResponseEntity<FundStructure> getFundStructureById(@PathVariable Long id) {
        Optional<FundStructure> fundStructure = fundStructureRepository.findById(id);
        return fundStructure.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar FundStructure
    @PutMapping("/{id}")
    public ResponseEntity<FundStructure> updateFundStructure(@PathVariable Long id, 
                                                             @RequestBody FundStructure fundStructureDetails) {
        return fundStructureRepository.findById(id)
            .map(fundStructure -> {
                fundStructure.setName(fundStructureDetails.getName());
                fundStructure.setInvestors(fundStructureDetails.getInvestors());
                FundStructure updatedFundStructure = fundStructureRepository.save(fundStructure);
                return ResponseEntity.ok(updatedFundStructure);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar FundStructure
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundStructure(@PathVariable Long id) {
        if (fundStructureRepository.existsById(id)) {
            fundStructureRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
