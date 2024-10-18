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
class DesenhoController {

    @Autowired
    private DesenhoRepo desenhoRepo;

    public DesenhoController() {
    }

    @GetMapping("/api/desenhos")
    Iterable<Desenho> getDesenhos(@RequestParam Optional<String> nome) {
        if (nome.isPresent()) {
            return desenhoRepo.findByNome(nome.get());
        } else {
            return desenhoRepo.findAll();
        }
    }

    @GetMapping("/api/desenhos/{id}")
    Optional<Desenho> getDesenho(@PathVariable long id) {
        return desenhoRepo.findById(id);
    }

    @PostMapping("/api/desenhos")
    Desenho createDesenho(@RequestBody Desenho desenho) {
        return desenhoRepo.save(desenho);
    }

    @PutMapping("/api/desenhos/{desenhoId}")
    Optional<Desenho> updateDesenho(@RequestBody Desenho desenhoRequest, @PathVariable long desenhoId) {
        Optional<Desenho> opt = desenhoRepo.findById(desenhoId);
        if (opt.isPresent()) {
            if (desenhoRequest.getId() == desenhoId) {
                desenhoRepo.save(desenhoRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do desenho com id " + desenhoId);
    }

    @DeleteMapping("/api/desenhos/{id}")
    void deleteDesenho(@PathVariable long id) {
        desenhoRepo.deleteById(id);
    }
}
