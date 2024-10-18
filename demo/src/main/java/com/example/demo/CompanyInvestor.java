package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("INTERNAL")
@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyInvestor extends Investor {
  private String companyType;

  @Column(unique = true)
  private String lei;

  public Iterable<CompanyInvestor> findCompanyInvestorsByNamePart(String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findCompanyInvestorsByNamePart'");
  }
}