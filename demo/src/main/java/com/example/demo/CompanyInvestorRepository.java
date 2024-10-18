package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInvestorRepository extends JpaRepository<CompanyInvestor, Long> {

    /**
     * Recupera uma lista de CompanyInvestors cujo nome contém a parte especificada.
     *
     * @param namePart Parte do nome a ser buscada.
     * @return Lista de CompanyInvestors que correspondem ao critério de busca.
     */
    @Query("SELECT c FROM CompanyInvestor c WHERE c.name LIKE %:namePart%")
    List<CompanyInvestor> findCompanyInvestorsByNamePart(@Param("namePart") String namePart);
}