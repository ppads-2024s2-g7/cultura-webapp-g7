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
class BrincadeiraController {

    @Autowired
    private BrincadeiraRepo brincadeiraRepo;

    public BrincadeiraController() {
    }

    // Recupera todas as brincadeiras ou por filtro opcional de habilidade principal
    @GetMapping("/api/brincadeiras")
    Iterable<Brincadeira> getBrincadeiras(@RequestParam Optional<String> habilidadePrincipal) {
        if (habilidadePrincipal.isPresent()) {
            return brincadeiraRepo.findByHabilidadePrincipal(habilidadePrincipal.get());
        }
        return brincadeiraRepo.findAll();
    }

    // Recupera uma brincadeira específica pelo ID
    @GetMapping("/api/brincadeiras/{id}")
    Optional<Brincadeira> getBrincadeira(@PathVariable long id) {
        return brincadeiraRepo.findById(id);
    }

    // Cria uma nova brincadeira
    @PostMapping("/api/brincadeiras")
    Brincadeira createBrincadeira(@RequestBody Brincadeira brincadeira) {
        return brincadeiraRepo.save(brincadeira);
    }

    // Atualiza os dados de uma brincadeira pelo ID
    @PutMapping("/api/brincadeiras/{brincadeiraId}")
    Optional<Brincadeira> updateBrincadeira(@RequestBody Brincadeira brincadeiraRequest, @PathVariable long brincadeiraId) {
        Optional<Brincadeira> opt = brincadeiraRepo.findById(brincadeiraId);
        if (opt.isPresent()) {
            if (brincadeiraRequest.getId() == brincadeiraId) {
                brincadeiraRepo.save(brincadeiraRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados da brincadeira com id " + brincadeiraId);
    }

    // Deleta uma brincadeira pelo ID
    @DeleteMapping("/api/brincadeiras/{id}")
    void deleteBrincadeira(@PathVariable long id) {
        brincadeiraRepo.deleteById(id);
    }
}
