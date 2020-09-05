package com.web;

import com.domain.*;
import com.service.ContractService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;
    private ContractService contractService;

    @Autowired
    public void UserController(UserService userService, ContractService contractService) {
        this.userService = userService;
        this.contractService = contractService;
    }

    @GetMapping("/user/")  //show all users
    public String all(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "user/all";
    }

    @GetMapping("/user/add") //get form for adding a new user
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/user/add")  //post form for adding a new user
    public String addUserFormSubmit(@ModelAttribute User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getUsers());
        return "user/all";
    }

    @GetMapping("/user/add/{id}") //user info get
    public String showInfo(@PathVariable long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("contracts", user.getContractsMadeByUser() );
        return "user/one";
    }

    @GetMapping("/user/add/{id}/edit")  //edit user get
    public String edit(@PathVariable long id, @ModelAttribute User user, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("urlparameter", id);
        return "user/edit";
    }

    @PostMapping("/user/add/{id}/edit")  //edit user post
    public String editPost(@PathVariable long id, @ModelAttribute User user, Model model) {
        User userOld = userService.getUser(id);
        user.setContractsMadeByUser(userOld.getContractsMadeByUser());
        userService.getUsers().put(id, user);
        model.addAttribute("users", userService.getUsers());
        return "user/all";
    }

    //HOUSEHOLD

    @GetMapping("/user/add/{id}/addHouseHoldInsurance") //household form get
    public String addHouseHoldGet(@PathVariable long id, Model model) {
        model.addAttribute("houseHoldInsurance", new HouseHoldInsurance());
        model.addAttribute("urlparameter", id);
        return "contract/addHouseHoldForm";
    }

    @PostMapping("/user/add/{id}/addHouseHoldInsurance")  //household form post
    public String addHouseHoldPost(@PathVariable long id, @ModelAttribute HouseHoldInsurance houseHoldInsurance, Model model) {
        User user = userService.getUser(id);
        user.addContractToUser(houseHoldInsurance);
        contractService.addContract(houseHoldInsurance);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("contracts", contractService.getContracts());
        return "user/all";
    }

    @GetMapping("/user/add/{id}/addHouseHold/{contractId}") //show household details get
    public String showHouseHold(@PathVariable long id, @PathVariable long contractId, Model model) {
        HouseHoldInsurance houseHoldInsurance = (HouseHoldInsurance) contractService.findContractById(contractId); //
        model.addAttribute("contract", houseHoldInsurance);
        model.addAttribute("contractIdParameter", contractId);
        model.addAttribute("userIdParameter", id);
        return "contract/HouseHoldInfo";
    }

    @GetMapping("/user/add/{id}/addHouseHold/{contractId}/edit") //edit household get
    public String editHouseHoldGet(@PathVariable long id, @PathVariable long contractId, Model model) {
        HouseHoldInsurance houseHoldInsurance = (HouseHoldInsurance)contractService.findContractById(contractId);
        model.addAttribute("contract", houseHoldInsurance);
        model.addAttribute("idParameter", id);
        model.addAttribute("contractParameter", contractId);
        return "contract/editHouseHold";
    }

    @PostMapping("/user/add/{id}/addHouseHold/{contractId}/edit") //edit household post
    public String editHouseHoldPost(@PathVariable long id, @PathVariable long contractId, @ModelAttribute HouseHoldInsurance contract, Model model) {
        contract.replaceId(contractId); //
        contractService.getContracts().put(contractId, contract);
        model.addAttribute("users", userService.getUsers());
        User user = userService.getUser(id);
        user.replaceOutDatedContract(contract);
        return "/user/all";
    }

    //HOUSE INSURANCE

    @GetMapping("/user/add/{id}/addHouseInsurance") //house form get
    public String addHouseGet(@PathVariable long id, Model model) {
        model.addAttribute("houseInsurance", new HouseInsurance());
        model.addAttribute("urlparameter", id);
        return "contract/addHouseForm";
    }

    @PostMapping("/user/add/{id}/addHouseInsurance")  //house form post
    public String addHousePost(@PathVariable long id, @ModelAttribute HouseInsurance houseInsurance, Model model) {
        User user = userService.getUser(id);
        user.addContractToUser(houseInsurance);
        contractService.addContract(houseInsurance);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("contracts", contractService.getContracts());
        return "user/all";
    }

    @GetMapping("/user/add/{id}/addHouse/{contractId}") //show household details get
    public String showHouse(@PathVariable long id, @PathVariable long contractId, Model model) {
        HouseInsurance houseInsurance = (HouseInsurance) contractService.findContractById(contractId); //
        model.addAttribute("contract", houseInsurance);
        model.addAttribute("contractIdParameter", contractId);
        model.addAttribute("userIdParameter", id);
        return "contract/HouseInfo";
    }

    @GetMapping("/user/add/{id}/addHouse/{contractId}/edit") //edit household get
    public String editHouseGet(@PathVariable long id, @PathVariable long contractId, Model model) {
        HouseInsurance houseInsurance = (HouseInsurance)contractService.findContractById(contractId);
        model.addAttribute("contract", houseInsurance);
        model.addAttribute("idParameter", id);
        model.addAttribute("contractParameter", contractId);
        return "contract/editHouse";
    }

    @PostMapping("/user/add/{id}/addHouse/{contractId}/edit") //edit household post
    public String editHousePost(@PathVariable long id, @PathVariable long contractId, @ModelAttribute HouseInsurance contract, Model model) {
        contract.replaceId(contractId); //
        contractService.getContracts().put(contractId, contract);
        model.addAttribute("users", userService.getUsers());
        User user = userService.getUser(id);
        user.replaceOutDatedContract(contract);
        return "/user/all";
    }

    //INJURY

    @GetMapping("/user/add/{id}/addInjuryInsurance") //injury form get
    public String addInjuryGet(@PathVariable long id, Model model) {
        model.addAttribute("injuryInsurance", new InjuryInsurance());
        model.addAttribute("users", userService.getUsers().values());
        model.addAttribute("urlparameter", id);
        return "contract/addInjuryForm";
    }

    @PostMapping("/user/add/{id}/addInjuryInsurance")  //injury form post
    public String addInjuryPost(@PathVariable long id, @ModelAttribute InjuryInsurance injuryInsurance, Model model) {
        User user = userService.getUser(id);
        user.addContractToUser(injuryInsurance);
        contractService.addContract(injuryInsurance);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("contracts", contractService.getContracts());
        return "user/all";
    }

    @GetMapping("/user/add/{id}/addInjury/{contractId}") //show injury details get
    public String showInjury(@PathVariable long id, @PathVariable long contractId, Model model) {
        InjuryInsurance injuryInsurance = (InjuryInsurance) contractService.findContractById(contractId);
        model.addAttribute("contract", injuryInsurance);
        model.addAttribute("contractIdParameter", contractId);
        model.addAttribute("userIdParameter", id);
        return "contract/InjuryInfo";
    }

    @GetMapping("/user/add/{id}/addInjury/{contractId}/edit") //edit injury get
    public String editInjuryGet(@PathVariable long id, @PathVariable long contractId, Model model) {
        InjuryInsurance injuryInsurance = (InjuryInsurance) contractService.findContractById(contractId);
        model.addAttribute("contract", injuryInsurance);
        model.addAttribute("idParameter", id);
        model.addAttribute("contractParameter", contractId);
        model.addAttribute("users", userService.getUsers().values());
        return "contract/editInjury";
    }

    @PostMapping("/user/add/{id}/addInjury/{contractId}/edit") //edit injury post
    public String editInjuryPost(@PathVariable long id, @PathVariable long contractId, @ModelAttribute InjuryInsurance contract, Model model) {
        contract.replaceId(contractId); //
        contractService.getContracts().put(contractId, contract);
        model.addAttribute("users", userService.getUsers());
        User user = userService.getUser(id);
        user.replaceOutDatedContract(contract);
        return "/user/all";
    }

    // TRAVEL

    @GetMapping("/user/add/{id}/addTravelInsurance") //travel form get
    public String addTravelGet(@PathVariable long id, Model model) {
        model.addAttribute("travelInsurance", new TravelInsurance());
        model.addAttribute("users", userService.getUsers().values());
        model.addAttribute("urlparameter", id);
        return "contract/addTravelForm";
    }

    @PostMapping("/user/add/{id}/addTravelInsurance")  //travel form post
    public String addTravelPost(@PathVariable long id, @ModelAttribute TravelInsurance travelInsurance, Model model) {
        User user = userService.getUser(id);
        user.addContractToUser(travelInsurance);
        contractService.addContract(travelInsurance);
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("contracts", contractService.getContracts());
        return "user/all";
    }

    @GetMapping("/user/add/{id}/addTravel/{contractId}") //show travel details get
    public String showTravel(@PathVariable long id, @PathVariable long contractId, Model model) {
        TravelInsurance travelInsurance = (TravelInsurance) contractService.findContractById(contractId);
        model.addAttribute("contract", travelInsurance);
        model.addAttribute("contractIdParameter", contractId);
        model.addAttribute("userIdParameter", id);
        return "contract/TravelInfo";
    }

    @GetMapping("/user/add/{id}/addTravel/{contractId}/edit") //edit travel get
    public String editTravelGet(@PathVariable long id, @PathVariable long contractId, Model model) {
        TravelInsurance travelInsurance = (TravelInsurance) contractService.findContractById(contractId);
        model.addAttribute("contract", travelInsurance);
        model.addAttribute("idParameter", id);
        model.addAttribute("contractParameter", contractId);
        model.addAttribute("users", userService.getUsers().values());
        return "contract/editTravel";
    }

    @PostMapping("/user/add/{id}/addTravel/{contractId}/edit") //edit travel post
    public String editTravelPost(@PathVariable long id, @PathVariable long contractId, @ModelAttribute TravelInsurance contract, Model model) {
        contract.replaceId(contractId); //
        contractService.getContracts().put(contractId, contract);
        model.addAttribute("users", userService.getUsers());
        User user = userService.getUser(id);
        user.replaceOutDatedContract(contract);
        return "/user/all";
    }

}
