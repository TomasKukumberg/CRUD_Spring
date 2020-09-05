package com.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Payments {

    private double insuranceAmount;
    private double monthlyPayment;

    public Payments(double insuranceAmount, double monthlyPayment) {

        if(insuranceAmount <= 0 || monthlyPayment <= 0) {
            throw new IllegalArgumentException();
        }

        this.insuranceAmount = insuranceAmount;
        this.monthlyPayment = monthlyPayment;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
