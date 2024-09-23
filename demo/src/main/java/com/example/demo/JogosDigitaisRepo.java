package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface JogosDigitaisRepo extends CrudRepository<JogosDigitais, Long> {
    // Método para buscar jogos por área
    List<JogosDigitais> findByArea(String area);
}
