package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customercrud")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String mobno;
	private String address;
	private Float total;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id, String name, String mobno, String address, Float total) {
		super();
		this.id = id;
		this.name = name;
		this.mobno = mobno;
		this.address = address;
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobno=" + mobno + ", address=" + address + ", total="
				+ total + "]";
	}
	
	
}
