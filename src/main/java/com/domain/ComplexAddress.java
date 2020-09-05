package com.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ComplexAddress {

    private Address permanent; //trvala
    private Address postal; //korespondencna

    public ComplexAddress(Address permanent, Address postal) {

        if(permanent == null) {
            throw new IllegalArgumentException();
        }

        this.permanent = permanent;

        if(postal == null) {
            this.postal = permanent;
        } else {
            this.postal = postal;
        }
    }

    public Address getPermanent() {
        return permanent;
    }

    public void setPermanent(Address permanent) {
        this.permanent = permanent;
    }

    public Address getPostal() {
        return postal;
    }

    public void setPostal(Address postal) {
        this.postal = postal;
    }

    public String toString() {
        return permanent.getStreetName() + " " + permanent.getHouseNumber() + " " + permanent.getPostalCode() + " "
                + permanent.getMunicipalName() +
                postal.getStreetName() + " " + postal.getHouseNumber() + " " + postal.getPostalCode() + " "
                + postal.getMunicipalName();
    }
}
