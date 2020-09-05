package com.service;

import com.domain.Contract;
import com.domain.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Data
@Service
public class ContractService {

    private HashMap<Long, Contract> contracts = new HashMap<Long, Contract>();;

    public ContractService() {
    }

    public void addContract(Contract contract) {
        contract.setId();
        contracts.put(contract.getId(), contract);
    }

    public void addContractToUser(User user, Contract contract) {
        user.getContractsMadeByUser().add(contract);
    }

    public void editAmount(Contract contract, double amount) {
        contract.setInsuranceAmount(amount);
    }

    public void editMonthlyPayment(Contract contract, double payment) {
        contract.setMonthlyPayment(payment);
    }

    public void printContracts() {
        System.out.println("Contract list: ");
        for(Contract contract : contracts.values()) {
            System.out.println(contract);
        }
        System.out.println("--------------------------");
    }

    public Contract findContractById(long id) {
        for(Contract contract : contracts.values()) {
            if(contract.getId() == id) {
                return contract;
            }
        }
        return null;
    }

    public void printContractsForUser(int userId) {
        System.out.println("Contracts for user with id number " + userId + ":");
        for(Contract contract : contracts.values()) {
            if(userId == contract.getInsurer().getDatabaseId()) {
                System.out.println(contract);
            }
        }
    }


}
