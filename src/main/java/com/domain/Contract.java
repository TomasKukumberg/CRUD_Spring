package com.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public abstract class Contract {

    private long id;
    private User insurer;
    private Date date;
    private Payments payments = new Payments();
    private static int idGenerator;

    public Contract(User insurer, Date date, Payments payments) {

        if(date == null || payments == null || payments.getInsuranceAmount() <= 0 || payments.getMonthlyPayment() <= 0) {
            throw new IllegalArgumentException("can't be null");
        }
        insurer.addContractToUser(this);
        //this.id = idGenerator++;
        this.insurer = insurer;
        this.date = date;
        this.payments = payments;
    }

    public void setId() {
        this.id = idGenerator++;
    }

    public void replaceId(long id) {
        this.id = id;
    }

    public LocalDate getContractFormationDate() {
        return date.getContractFormation();
    }

    public User getInsurer() {
        return insurer;
    }

    public LocalDate getStartOfInsurance() {
        return date.getStartOfInsurance();
    }

    public LocalDate getEndOfInsurance() {
        return date.getEndOfInsurance();
    }

    public double getInsuranceAmount() {
        return payments.getInsuranceAmount();
    }

    public double getMonthlyPayment() {
        return payments.getMonthlyPayment();
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.payments.setInsuranceAmount(insuranceAmount);
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.payments.setMonthlyPayment(monthlyPayment);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + " " + getContractFormationDate() + " " + insurer + " " + getStartOfInsurance() + " " +
                getEndOfInsurance() + " " + getInsuranceAmount() + " " + getMonthlyPayment();
    }
}
