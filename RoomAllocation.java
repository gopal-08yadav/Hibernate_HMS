package com.hms;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RoomAllocation {
    @Id
    @Column(length = 10)
    private String bookingId;
    
    @Temporal(TemporalType.DATE)
    private Date bookingDate = new Date();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CustomerID")
    private Customers customer; // foreign key in db, but Hibernate will hold customer object

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "RoomNumber")
    private Room room;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Food_Id")
    private Food food;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    // Use this method to set booking date
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public RoomAllocation(String bookingId, Customers customer, Room room, Food food) {
        super();
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.food = food;
    }

    public RoomAllocation() {
        super();
    }

    @Override
    public String toString() {
        return "BookingRoom [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", customer=" + customer
                + ", room=" + room + ", food=" + food + "]";
    }
}
