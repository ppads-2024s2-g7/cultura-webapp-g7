package com.example.demo;

import com.example.demo.FundStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundStructureRepository extends JpaRepository<FundStructure, Long> {

    /**
     * Recupera uma lista de FundStructures cujo nome contém a parte especificada.
     *
     * @param namePart Parte do nome a ser buscada.
     * @return Lista de FundStructures que correspondem ao critério de busca.
     */
    @Query("SELECT f FROM FundStructure f WHERE f.name LIKE %:namePart%")
    List<FundStructure> findFundStructuresByNamePart(@Param("namePart") String namePart);
}
