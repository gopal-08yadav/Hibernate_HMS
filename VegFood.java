package com.hms;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VegFood {
    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vegfood_id;
    
    @Column(length=50)
    private String food_name;
    
    @Column(length=20)
    private String food_cost;

	public Long getVegfood_id() {
		return vegfood_id;
	}

	public void setVegfood_id(Long vegfood_id) {
		this.vegfood_id = vegfood_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_cost() {
		return food_cost;
	}

	public void setFood_cost(String food_cost) {
		this.food_cost = food_cost;
	}	

	
	
	public VegFood() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VegFood(String food_name, String food_cost) {
		super();
		
		this.food_name = food_name;
		this.food_cost = food_cost;
	}

	@Override
	public String toString() {
		return "VegFood [vegfood_id=" + vegfood_id + ", food_name=" + food_name + ", food_cost=" + food_cost + "]";
	}
    
    
}
