package com.domain;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
public class Date {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractFormation;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startOfInsurance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endOfInsurance;

    public Date(LocalDate contractFormation, LocalDate startOfInsurance, LocalDate endOfInsurance) {

        if(contractFormation == null || startOfInsurance == null || endOfInsurance == null) {
            throw new IllegalArgumentException();
        }
        this.contractFormation = contractFormation;
        this.startOfInsurance = startOfInsurance;
        this.endOfInsurance = endOfInsurance;
    }

    public LocalDate getContractFormation() {
        return contractFormation;
    }

    public void setContractFormation(LocalDate contractFormation) {
        this.contractFormation = contractFormation;
    }

    public LocalDate getStartOfInsurance() {
        return startOfInsurance;
    }

    public void setStartOfInsurance(LocalDate startOfInsurance) {
        this.startOfInsurance = startOfInsurance;
    }

    public LocalDate getEndOfInsurance() {
        return endOfInsurance;
    }

    public void setEndOfInsurance(LocalDate endOfInsurance) {
        this.endOfInsurance = endOfInsurance;
    }
}
