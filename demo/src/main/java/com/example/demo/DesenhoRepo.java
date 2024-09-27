package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesenhoRepo extends JpaRepository<Desenho, Long> {

    Iterable<Desenho> findByNome(String nome);
}
