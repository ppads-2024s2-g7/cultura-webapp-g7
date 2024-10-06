package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BrincadeiraRepo extends CrudRepository<Brincadeira, Long> {

    Iterable<Brincadeira> findByHabilidadePrincipal(String habilidadePrincipal);
}
