package com.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class LifeInsurance extends Contract {

    public LifeInsurance(User insurer, Date date, Payments payments) {
        super(insurer, date, payments);
    }
}
