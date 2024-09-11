package com.hotel;


import java.util.List;

import com.hms.serviceImp.*;
import Services.*;
import java.io.*;

import java.util.Scanner;



import static com.hotel.AllOperations.*;

public class MainOperation {

	 static AdminService adminService = new AdminServiceImpl();
	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        final String ANSI_RESET = "\u001B[0m";
	        final String ANSI_YELLOW = "\u001B[33m";
	        System.out.println(ANSI_YELLOW + "Welcome To HOTEL MANAGEMENT SYSTEM" + ANSI_RESET);

	        if (login()) {
	            // If login successful, show other operations
	            mainOps();
	        } else {
	            System.out.println("Login failed. Exiting...");
	        }
	        
	        
	    }

	    private static boolean login() {
	        System.out.println("Admin Login");
	        System.out.print("Username: ");
	        String username = sc.nextLine();
	        System.out.print("Password: ");
	        String password = sc.nextLine();

	        return adminService.authenticateAdmin(username, password);
	    }


    public static void mainOps() {
        while (true) {
            System.out.println("Press 1.Manage Customers\nPress 2.Manage Rooms\n"
                    + "Press 3.Manage Food\nPress 4.Manage Booking Room\n"
                    + "Press 5.Manage Driver\nPress 6.Manage Employees\n"
                    + "Press 7.Manage Department\nPress 8.Quit");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    customerOperations();
                    System.out.println("=======================================");
                    break;

                case 2:
                    roomOperations();
                    System.out.println("=======================================");
                    break;

                case 3:
                    foodTypeSelection();  
                    System.out.println("=======================================");
                    break;

                case 4:
                	bookingRoomOperations();
                    System.out.println("=======================================");
                    break;

                case 5:
                	driverOperations();
                    System.out.println("=======================================");
                    break;

                case 6:
                    employeeOperations();
                    System.out.println("=======================================");
                    break;

                case 7:
                    departmentOperations();
                    System.out.println("=======================================");
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
