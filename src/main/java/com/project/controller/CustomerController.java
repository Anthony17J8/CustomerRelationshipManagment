package com.project.controller;

import com.project.dao.CustomerDAO;
import com.project.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {

        // get customer list from the dao
        List<Customer> customers = customerDAO.getCustomers();

        // add list to the SpringMVC model
        theModel.addAttribute("customers", customers);

        return "list-customers";
    }
}
