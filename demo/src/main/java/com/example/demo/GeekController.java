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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class GeekController {

    @Autowired
    private GeekRepo geekRepo;

    public GeekController() {
    }

    @GetMapping("/api/geeks")
    Iterable<Geek> getGeeks() {
        return geekRepo.findAll();
    }

    @GetMapping("/api/geeks/{id}")
    Optional<Geek> getGeek(@PathVariable long id) {
        return geekRepo.findById(id);
    }

    @PostMapping("/api/geeks")
    Geek createGeek(@RequestBody Geek geek) {
        return geekRepo.save(geek);
    }

    @PutMapping("/api/geeks/{geekId}")
    Optional<Geek> updateGeek(@RequestBody Geek geekRequest, @PathVariable long geekId) {
        Optional<Geek> opt = geekRepo.findById(geekId);
        if (opt.isPresent()) {
            if (geekRequest.getId() == geekId) {
                return Optional.of(geekRepo.save(geekRequest));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do geek com id " + geekId);
    }

    @DeleteMapping("/api/geeks/{id}")
    void deleteGeek(@PathVariable long id) {
        geekRepo.deleteById(id);
    }
}
