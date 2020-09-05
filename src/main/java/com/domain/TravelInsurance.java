package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TravelInsurance extends LifeInsurance {

    private User insured;
    private boolean insideEu;
    private TravelReason travelReason;

    public TravelInsurance(User insurer, Date date, Payments payments, User insured,
                           boolean insideEu, TravelReason travelReason) {
        super(insurer, date, payments);

        if(insured == null || travelReason == null) {
            throw new IllegalArgumentException();
        }

        this.insured = insured;
        this.insideEu = insideEu;
        this.travelReason = travelReason;
    }

    public String toString() {
        return "Contract ID: " + getId() + " Formation: " + getContractFormationDate() + " Start: " + getStartOfInsurance() +
                " End: " + getEndOfInsurance() + " Amount: " + getInsuranceAmount() + "$ Monthly: "
                + getMonthlyPayment() + "$ Insured ID: " + insured.getDatabaseId() + " Inside EU: " + insideEu +
                " Travel reason: " + travelReason.name();
    }
}
