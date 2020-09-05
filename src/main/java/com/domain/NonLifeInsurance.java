package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class NonLifeInsurance extends Contract {

    private HouseType houseType;
    private Address address;
    private double housePrice;

    public NonLifeInsurance(User insurer, Date date, Payments payments, HouseType houseType, Address address, double housePrice) {
        super(insurer, date, payments);

        if(houseType == null || address == null || housePrice < 0) {
            throw new IllegalArgumentException();
        }

        this.houseType = houseType;
        this.address = address;
        this.housePrice = housePrice;
    }
}
