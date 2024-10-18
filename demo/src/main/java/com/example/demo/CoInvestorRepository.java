package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoInvestorRepository extends JpaRepository<CoInvestor, Long> {

    // Método para buscar co-investidores por parte do nome
    @Query("SELECT c FROM CoInvestor c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :namePart, '%'))")
    List<CoInvestor> findCompanyCoInvestorsByNamePart(@Param("namePart") String namePart);
}
