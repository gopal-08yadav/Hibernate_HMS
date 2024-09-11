package com.hms;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room_Id", length = 10, nullable = false)
    private Long room_id; 
	@Column(name = "RoomNumber", length = 10,nullable = false)
	private String roomnumber;
	@Column(name = "Availablity", length = 50,nullable = false)
	private String availability;
	@Column(name = "Clean_Status", length = 25,nullable = false)
	private String cleanstatus;
	@Column(name = "Price",length=50,nullable = false)
	private String price;
	@Column(name = "Bed_Type", length = 25,nullable = false)
	private String bedtype;
	
	//Setter And Getter
	public String getRoomNumber() {
		return roomnumber;
	}
	public void setRoomNumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getCleanStatus() {
		return cleanstatus;
	}
	public void setCleanStatus(String cleanstatus) {
		this.cleanstatus = cleanstatus;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBedType() {
		return bedtype;
	}
	public void setBedType(String bedtypes) {
		this.bedtype = bedtypes;
	}
	
	//All argument Constructor
	public Room(String roomnumber, String availability, String cleanstatus, String price,
			String bedtype) {
		super();
		this.roomnumber = roomnumber;
		this.availability = availability;
		this.cleanstatus = cleanstatus;
		this.price = price;
		this.bedtype = bedtype;
		//this.email = email;
		//this.phone = phone;
	}
	//Default Constructor
	public Room() {
		super();
	}
	//ToString method
	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", RoomNumber=" + roomnumber + ", Availability=" + availability + ",CleanStatus=" + cleanstatus+ ", price=" + price + ", bedtype=" + bedtype + "]";
	}
} 