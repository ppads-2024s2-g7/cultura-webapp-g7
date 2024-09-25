package com.example.demo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

// Repositório para a entidade Filme
public interface FilmeRepo extends CrudRepository<Filme, Long> {

    // Método customizado para buscar filmes pelo ano de lançamento
    List<Filme> findByAnoLancamento(int anoLancamento);
}
