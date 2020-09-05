package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HouseHoldInsurance extends NonLifeInsurance {

    private double furniturePrice;

    public HouseHoldInsurance(User insurer, Date date, Payments payments, HouseType houseType,
                              Address address, double housePrice, double furniturePrice) {
        super(insurer, date, payments, houseType, address, housePrice);

        if(furniturePrice <= 0) {
            throw new IllegalArgumentException();
        }

        this.furniturePrice = furniturePrice;
    }

    @Override
    public String toString() {
        return "Contract ID: " + getId() + " Formation: " + getContractFormationDate() +
                " Start: " + getStartOfInsurance() + " End: " + getEndOfInsurance() +
                " Amount: " + getInsuranceAmount() + "$ Monthly: " + + getMonthlyPayment() +
                "$ Price of house: " + getHousePrice() + "$ Price of furniture: " + furniturePrice +"$";
    }
}
