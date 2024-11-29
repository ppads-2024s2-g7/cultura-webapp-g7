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
class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    public MusicaController() {
    }

    @GetMapping("/api/musicas")
    Iterable<Musica> getMusicas(@RequestParam Optional<String> cantor) {
        if (cantor.isPresent()) {
            return musicaRepository.findByCantor(cantor.get());
        } else {
            return musicaRepository.findAll();
        }
    }

    @GetMapping("/api/musicas/{id}")
    Optional<Musica> getMusica(@PathVariable long id) {
        return musicaRepository.findById(id);
    }

    @PostMapping("/api/musicas")
    Musica createMusica(@RequestBody Musica musica) {
        Musica createdMusica = musicaRepository.save(musica);
        return createdMusica;
    }

    @PutMapping("/api/musicas/{musicaId}")
    Optional<Musica> updateMusica(@RequestBody Musica musicaRequest, @PathVariable long musicaId) {
        Optional<Musica> opt = musicaRepository.findById(musicaId);
        if (opt.isPresent()) {
            if (musicaRequest.getId() == musicaId) {
                musicaRepository.save(musicaRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados da música com id " + musicaId);
    }

    @DeleteMapping("/api/musicas/{id}")
    void deleteMusica(@PathVariable long id) {
        musicaRepository.deleteById(id);
    }
}
    