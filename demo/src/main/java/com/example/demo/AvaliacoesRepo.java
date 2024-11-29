package com.example.demo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AvaliacoesRepo extends CrudRepository<Avaliacoes, Long> {
    List<Avaliacoes> findByTitulo(String titulo);
}
