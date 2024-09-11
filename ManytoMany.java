package com.hms.association;
import javax.persistence.*;
import com.hms.Food;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ManytoMany {

    @Id
    @Column(name = "Cust_Id", length = 10)
    private String custId;

    @Column(name = "Cust_Name", length = 50)
    private String custName;

    @Column(name = "Cust_Gender", length = 25)
    private String custGender;

    @Column(name = "Cust_Num")
    private String custNum;

    @Column(name = "Room_Num", length = 25)
    private String roomNum;

    @Column(name = "Deposit", length = 30)
    private String deposit;

    @Column(name = "Country", length = 25)
    private String country;

    @ManyToMany
    @JoinTable(
        name = "Customer_Food",
        joinColumns = @JoinColumn(name = "Cust_Id"),
        inverseJoinColumns = @JoinColumn(name = "Food_Id")
    )
    private Set<Food> foods = new HashSet<>();

    @Column(name = "CheckInTime")
    private LocalDate checkInTime;

    // Default Constructor
    public ManytoMany() {}

    // All-argument Constructor
    public ManytoMany(String custId, String custName, String custGender, String custNum,
                     String roomNum, String deposit, String country, LocalDate checkInTime) {
        this.custId = custId;
        this.custName = custName;
        this.custGender = custGender;
        this.custNum = custNum;
        this.roomNum = roomNum;
        this.deposit = deposit;
        this.country = country;
        this.checkInTime = checkInTime;
    }

    // Getters and Setters
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }

    public LocalDate getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime;
    }

    @Override
    public String toString() {
        return "Customers [custId=" + custId + ", custName=" + custName + ", custGender=" + custGender +
               ", custNum=" + custNum + ", roomNum=" + roomNum + ", deposit=" + deposit + ", country=" + country +
               ", checkInTime=" + checkInTime + "]";
    }
}

