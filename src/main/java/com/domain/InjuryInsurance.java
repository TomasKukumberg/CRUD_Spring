package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class InjuryInsurance extends LifeInsurance {

    private User insured;
    private double permanentConsequences;
    private double deathFromInjury;
    private double dailyCompensationForHospitalization;

    public InjuryInsurance(User insurer, Date date, Payments payments, User insured, double permanentConsequences,
                           double deathFromInjury, double dailyCompensationForHospitalization) {
        super(insurer, date, payments);

        if(permanentConsequences < 0 || deathFromInjury < 0 || dailyCompensationForHospitalization < 0) {
            throw new IllegalArgumentException();
        }

        this.insured = insured;
        this.permanentConsequences = permanentConsequences;
        this.deathFromInjury = deathFromInjury;
        this.dailyCompensationForHospitalization = dailyCompensationForHospitalization;
    }

    public String toString() {
        return "Contract ID: " + getId() + " Formation: " + getContractFormationDate() + " Start: " + getStartOfInsurance() +
                " End: " + getEndOfInsurance() + " Amount: " + getInsuranceAmount() + "$ Monthly: "
                + getMonthlyPayment() + "$ Perma conseq: " + permanentConsequences + "$ Death: " + deathFromInjury +
                "$ Daily comp: " + dailyCompensationForHospitalization +"$";
    }
}
