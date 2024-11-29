package com.example.demo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class AvaliacoesController {

    @Autowired
    private AvaliacoesRepo avaliacoesRepo;

    public AvaliacoesController() {
    }

    // Recupera todas as avaliações ou filtra por título opcionalmente
    @GetMapping("/api/avaliacoes")
    Iterable<Avaliacoes> getAvaliacoes(@RequestParam Optional<String> titulo) {
        if (titulo.isPresent()) {
            return avaliacoesRepo.findByTitulo(titulo.get());
        }
        return avaliacoesRepo.findAll();
    }

    // Recupera uma avaliação específica pelo ID
    @GetMapping("/api/avaliacoes/{id}")
    Optional<Avaliacoes> getAvaliacao(@PathVariable long id) {
        return avaliacoesRepo.findById(id);
    }

    // Cria uma nova avaliação
    @PostMapping("/api/avaliacoes")
    Avaliacoes createAvaliacao(@RequestBody Avaliacoes avaliacao) {
        return avaliacoesRepo.save(avaliacao);
    }

    // Atualiza os dados de uma avaliação pelo ID
    @PutMapping("/api/avaliacoes/{avaliacaoId}")
    Optional<Avaliacoes> updateAvaliacao(@RequestBody Avaliacoes avaliacaoRequest, @PathVariable long avaliacaoId) {
        Optional<Avaliacoes> opt = avaliacoesRepo.findById(avaliacaoId);
        if (opt.isPresent()) {
            if (avaliacaoRequest.getId() == avaliacaoId) {
                avaliacoesRepo.save(avaliacaoRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da avaliação com id " + avaliacaoId);
    }

    // Deleta uma avaliação pelo ID
    @DeleteMapping("/api/avaliacoes/{id}")
    void deleteAvaliacao(@PathVariable long id) {
        avaliacoesRepo.deleteById(id);
    }
}
