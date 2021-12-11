package com.gl.springMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.springMVC.entity.Customer;
import com.gl.springMVC.service.CustomerService;

public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/list")
	public String listCustomer(Model model) {
	List<Customer> customer = customerService.findAll();
	model.addAttribute("Customer",customer);
	return "dummy";
}
	@RequestMapping("/showFromForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer cust = new Customer();
		theModel.addAttribute("Customer", cust);
		return "newform";
		
	}
	@RequestMapping("/showFormForUpdate")
	public String showFromForUpdate(@RequestParam("id") int theId,Model theModel) {
		Customer cust = customerService.findById(theId);
		theModel.addAttribute("customer", cust);
		return "newform";
		
	}
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id") int id,@RequestParam("firstname")
	String firstname,@RequestParam("lastname")String lastname,@RequestParam("email") String email) {
		System.out.println(id);
		Customer cust;
		if(id!=0) {
			cust = customerService.findById(id);
			cust.setFirstname(firstname);
			cust.setLastname(lastname);
			cust.setEmail(email);
		}else
			cust = new Customer();
		customerService.save(cust);
		return "redirect:/Customer/list";
		
	}
	
	public String delete(@RequestParam("id") int theId) {
		customerService.deletedById(theId);
		return "redirect:/customer/list";
		
	}
	
	

}
