package com.cts.cloudpoc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping(path="/add",consumes="application/json")
	@ResponseBody
	/*public String add(@RequestParam String userName, @RequestParam String password,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNo, 
			@RequestParam String address1, @RequestParam String address2, @RequestParam String emailId) {*/
	public String add(@RequestBody Customer customer) {
		/*Customer c = new Customer();
		c.setPassword(password);
		c.setUserName(userName);
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setPhoneNo(phoneNo);
		c.setEmailId(emailId);
		c.setAddress1(address1);
		c.setAddress2(address2);
	*/	//customer.setDate(new Date());
	System.out.println(customer.getDate());
		customerRepository.save(customer);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAll(){
		Iterable<Customer> i = customerRepository.findAll();
		Iterator<Customer> ii = i.iterator();
		while(ii.hasNext()) {
			Customer c = ii.next();
			System.out.println(c.getDate());
		}
		return i;
	}
	
	@GetMapping(path="/find")
	public @ResponseBody List<Customer> findCustomer(@RequestParam Integer id, @RequestParam String from, @RequestParam String to){
		SimpleDateFormat sd= new SimpleDateFormat("DD-MMM-YYYY");
		System.out.println("from "+from);
		System.out.println("to "+to);
		
		Date fromDate =null;
		Date toDate = null;
		try {
		fromDate = sd.parse(from);
		toDate = sd.parse(to);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("from Date"+fromDate);
		System.out.println("to Date"+toDate);
		
		return customerRepository.findByIdAndDateBetween(id, fromDate, toDate);
	}
}
