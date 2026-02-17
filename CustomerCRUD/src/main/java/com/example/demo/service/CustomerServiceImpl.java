package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateID;
import com.example.demo.exception.DuplicateName;
import com.example.demo.exception.InvalidID;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cr;

	@Override
	public void add(Customer customer) {

		
		String mobno=customer.getMobno().trim();
		
		if(mobno.startsWith("+91"))
			mobno=mobno.substring(3);
		
		
		if(mobno.length()==10) {
			if(mobno.charAt(0)=='0'||mobno.charAt(0)=='1'||mobno.charAt(0)=='2'||mobno.charAt(0)=='3'||mobno.charAt(0)=='4'||mobno.charAt(0)=='5')
				throw new InvalidMobileNumber("Invalid Mobile Number");
			
			for(int i=0;i<mobno.length();i++) {
				if(!Character.isDigit(mobno.charAt(i)))
					throw new InvalidMobileNumber("Invalid Mobile Number");
			}
		}else
			throw new InvalidMobileNumber("Invalid Mobile Number");
		
		
		
//		Integer id=customer.getId();
//		
//		if(cr.existsById(id))
//			throw new DuplicateID("ID Dupicate");
//		if(id<=0) {
//			throw new InvalidID("ID Must Be Positive");
//		}
		
		String name=customer.getName().trim();
		List<Customer>list=cr.findByName(name);
		if(!list.isEmpty())
			throw new DuplicateName("Name are Duplicated");
		
		cr.save(customer);

	}

	@Override
	public List<Customer> display() {

		return cr.findAll(); // select * from customer
	}

	@Override
	public Customer delete(Integer id) {

		// search
		if (cr.findById(id).isPresent()) {
			Customer temp = cr.findById(id).get();
			cr.deleteById(id);
			return temp;
		}
		return null;
	}

	@Override
	public void update(Customer customer, Integer id) {

		customer.setId(id);
		cr.save(customer);

	}

	@Override
	public Customer search(Integer id) {

		if (cr.findById(id).isPresent()) {
			Customer temp = cr.findById(id).get();
			return temp;
		}
		return null;

	}

	@Override
	public void addAll(List<Customer> list) {

		cr.saveAll(list);

	}

	@Override
	public Customer findMob(String mobno) {
		return cr.findByMobno(mobno);

	}

}
