package com.hms;
import com.hms.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Entity
public class NonVegfood{

	    @Id
	    @Column(length = 10)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long nvegfood_id;
	    
	    @Column(length=50)
	    private String food_name;
	    
	    @Column(length=20)
	    private String food_cost;

		public Long getVegfood_id() {
			return nvegfood_id;
		}

		public void setVegfood_id(Long nvegfood_id) {
			this.nvegfood_id = nvegfood_id;
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

		
		
		public NonVegfood() {
			super();
			// TODO Auto-generated constructor stub
		}

		public NonVegfood( String food_name, String food_cost) {
			super();
			
			this.food_name = food_name;
			this.food_cost = food_cost;
		}

		@Override
		public String toString() {
			return "NonVegFood [nvegfood_id=" + nvegfood_id + ", food_name=" + food_name + ", food_cost=" + food_cost + "]";
		}
	    
	    
} 