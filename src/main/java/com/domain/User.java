package com.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {

    private long databaseId;
    private Name name;
    private String birthId;
    private String email;
    private ComplexAddress address;
    private ArrayList<Contract> contractsMadeByUser = new ArrayList<Contract>();
    private static int idGenerator;

    public User() {

    }

    public void setAll(User user) {
        this.databaseId = user.getDatabaseId();
        this.name = user.getName();
        this.birthId = user.getBirthId();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.contractsMadeByUser = user.getContractsMadeByUser();
    }

    public User(Name name, String birthId, String email, ComplexAddress address) {

        if(name == null || birthId.isEmpty() || email.isEmpty() || address.getPermanent() == null) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.birthId = birthId;
        this.email = email;
        this.address = address;

        if(address.getPostal() == null) {
            this.address.setPostal(address.getPermanent());
        } else {
            this.address.setPostal(address.getPostal());
            this.address.setPermanent(address.getPermanent());
        }

    }

    public void setId() {
        this.databaseId = idGenerator++;
    }

    public void addContractToUser(Contract contract) {
        contractsMadeByUser.add(contract);
    }

    public void replaceOutDatedContract(Contract contract) {
        for(int i = 0; i < contractsMadeByUser.size(); i++) {
            if(contract.getId() == contractsMadeByUser.get(i).getId()) {
                contractsMadeByUser.set(i, contract);
            }
        }
    }


    @Override
    public String toString() {
        return " First name: " + name.getFirst()  + " Second name: " + " " + name.getSecond() +
                " Birth ID: " + birthId + " email: " + email + " PE address: " + address;
    }
}

