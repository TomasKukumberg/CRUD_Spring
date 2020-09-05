package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Address {

    private Integer postalCode;
    private String municipalName;
    private String streetName;
    private Integer houseNumber;

    public Address(Integer postalCode, String municipalName, String streetName, Integer houseNumber) {

        if(postalCode <= 0 || houseNumber <= 0 || municipalName.isEmpty() || streetName.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.postalCode = postalCode;
        this.municipalName = municipalName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }


    public String toString() {
        return postalCode + " " + municipalName + " " + streetName + " " + houseNumber;
    }
}
