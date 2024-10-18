package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCulturalRepository extends JpaRepository<ItemCultural, Long> {
    // Você pode adicionar métodos específicos de busca aqui, se necessário.
    
    // Exemplo de método que busca itens culturais pelo nome
    Iterable<ItemCultural> findByNome(String nome);
}
