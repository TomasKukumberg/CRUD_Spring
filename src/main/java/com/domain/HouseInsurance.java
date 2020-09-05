package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HouseInsurance extends NonLifeInsurance {

    private boolean hasGarageInsured;

    public HouseInsurance(User insurer, Date date, Payments payments, HouseType houseType,
                          Address address, double housePrice, boolean hasGarageInsured) {
        super(insurer, date, payments, houseType, address, housePrice);
        this.hasGarageInsured = hasGarageInsured;
    }

    public String toString() {
        return "Contract ID: " + getId() + " Formation: " + getContractFormationDate() + " Start: " + getStartOfInsurance() +
                " End: " + getEndOfInsurance() + " Amount: " + getInsuranceAmount() + "$ Monthly: "
                + getMonthlyPayment() + "$ Price of house: " + getHousePrice() + " Garage insurance: " + hasGarageInsured;
    }
}
