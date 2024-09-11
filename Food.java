package com.hms;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Food {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment
    @Column(name = "Food_Id", nullable = false)
    private Long food_id;
	@Column(name = "Food_Name", length = 100,nullable = false)
	private String food_name;
	@Column(name = "Food_Cost", length = 25,nullable = false)
	private String food_cost;
	
	
	//Setter And Getter
	 public Long getFood_id() {
	        return food_id;
	    }

	    public void setFood_id(Long food_id) {
	        this.food_id = food_id;
	    }
	public String getFood_Name() {
		return food_name;
	}
	public void setFood_Name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_Cost() {
		return food_cost;
	}
	public void setFood_Cost(String food_cost) {
		this.food_cost = food_cost;
	}
	
	//All argument Constructor
	 public Food(String food_name, String food_cost) {
	        this.food_name = food_name;
	        this.food_cost = food_cost;
	    }

	//Default Constructor
	public Food() {
		super();
	}
	//ToString method
	@Override
	public String toString() {
		return "Food [food_id=" + food_id + ", food_name=" + food_name + ",food_cost=" + food_cost+ "]";
	}
}