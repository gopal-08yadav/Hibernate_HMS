package com.hotel;

import Services.RoomService;

import Services.CustomerService;
import Services.DriversService;
import Services.EmployeesService;
import Services.DepartmentService;
import Services.NonVegFoodService;
import Services.VegFoodService;
import Services.BookingRoomService;

import com.hms.serviceImp.RoomServiceImpl;
import com.hms.util.HibernateUtil;
//import com.student.entity.Student;
import com.hms.serviceImp.CustomerServiceImpl;
import com.hms.serviceImp.DriversServiceImpl;
import com.hms.serviceImp.EmployeesServiceImpl;
import com.hms.serviceImp.DepartmentServiceImpl;
import com.hms.serviceImp.NonVegFoodServiceImpl;
import com.hms.serviceImp.VegFoodServiceImpl;
import com.hms.serviceImp.BookingRoomServiceImpl;

import com.hms.Dao.*;
import com.hms.DaoImp.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.Session;

import com.hms.Room;
import com.hms.Customers;
import com.hms.Drivers;
import com.hms.Employees;
import com.hms.Department;
import com.hms.NonVegfood;
import com.hms.VegFood;
import com.hms.BookingRoom;

import com.hms.exception.ResourceNotFoundException;

public class AllOperations {

    static RoomService roomService = new RoomServiceImpl();
    static CustomerService customerService = new CustomerServiceImpl();
    static DriversService driverService = new DriversServiceImpl();
    static EmployeesService employeeService = new EmployeesServiceImpl();
    static DepartmentService departmentService = new DepartmentServiceImpl();
    static NonVegFoodService nvegfoodService = new NonVegFoodServiceImpl();
    static VegFoodService vegfoodService = new VegFoodServiceImpl();
    static BookingRoomService bookingRoomService = new BookingRoomServiceImpl();

    static Scanner sc = new Scanner(System.in);

    // Input methods for each entity

    public static Room roomInputs() {
        sc.nextLine();
        System.out.println("Enter Room Number");
        String roomNumber = sc.nextLine();

        System.out.println("Enter Availability");
        String availability = sc.nextLine();

        System.out.println("Enter Clean Status");
        String cleanStatus = sc.nextLine();

        System.out.println("Enter Price");
        String price = sc.nextLine();

        System.out.println("Enter Bed Type");
        String bedType = sc.nextLine();

        return new Room(roomNumber, availability, cleanStatus, price, bedType);
    }

    public static Customers customerInputs() {
        sc.nextLine();
     
        System.out.println("Enter Customer Name");
        String cust_name = sc.nextLine();

        System.out.println("Enter Gender");
        String gender = sc.nextLine();

        System.out.println("Enter Phone Number");
        String phoneNumber = sc.nextLine();

        System.out.println("Enter Deposit");
        String deposit = sc.nextLine();

        System.out.println("Enter Country");
        String country = sc.nextLine();

        LocalDate date1 = LocalDate.now();
		return new Customers(cust_name, gender, phoneNumber, deposit, country, date1);
    }


    public static Drivers driverInputs() {
        Session session = HibernateUtil.getSessionFactory().openSession(); // Create a session
        session.beginTransaction();
        sc.nextLine();

        System.out.println("Enter Driver Name:");
        String driver_name = sc.nextLine();

        System.out.println("Enter Driver Gender:");
        String driver_gender = sc.nextLine();

        System.out.println("Enter Car Brand:");
        String car_brand = sc.nextLine();
        
        System.out.println("Enter Car Number:");
        String vehical_num = sc.nextLine();

        System.out.println("Enter Driver Availability:");
        String availability = sc.nextLine();

        System.out.println("Enter Location:");
        String location = sc.nextLine();

        System.out.println("Enter Car Company:");
        String company = sc.nextLine();
        
       
        // Here, we prompt the user to enter the Customer ID when the driver is being created
        System.out.println("Enter Customer ID for pickup request:");
        Long cust_id = sc.nextLong();

        // Fetch the Customer entity from the database using the provided cust_id
        Customers customer = session.get(Customers.class, cust_id);

        if (customer == null) {
            System.out.println("Customer with ID " + cust_id + " not found.");
            return null; // Customer not found, return null or handle this situation as needed
        }

        // Create and return the new Drivers object with the associated Customer
        Drivers driver = new Drivers(driver_name, driver_gender, car_brand,vehical_num, availability, location, company, customer);

        session.save(driver); // Save the driver to the database
        session.getTransaction().commit(); // Commit the transaction
        session.close(); // Close the session

        return driver;
        
       
    }
    
    public static Employees employeeInputs() {
        sc.nextLine();
        System.out.println("Enter Employee Aadhar");
        String emp_aadhar = sc.nextLine();

        System.out.println("Enter Employee Name");
        String emp_name = sc.nextLine();

        System.out.println("Enter Employee Gender");
        String emp_gender = sc.nextLine();

        System.out.println("Enter Employee Age");
        String emp_age = sc.nextLine();
        
        System.out.println("Enter Employee Salary");
        String emp_salary = sc.nextLine();

        System.out.println("Enter Employee Phone");
        String emp_phone = sc.nextLine();

        System.out.println("Enter Employee Email");
        String email = sc.nextLine();

        System.out.println("Enter Employee Job");
        String emp_job = sc.nextLine();

        return new Employees(emp_aadhar, emp_name, emp_gender, emp_age, emp_salary, emp_phone, email, emp_job);
    }

    public static Department departmentInputs() {
        sc.nextLine();
        System.out.println("Enter Department Name");
        String departmentname = sc.nextLine();

        System.out.println("Enter Department Budget");
        String departmentbudget = sc.nextLine();

        return new Department(departmentname, departmentbudget);
    }

    public static NonVegfood nvegfoodInputs() {
        sc.nextLine();
        
        System.out.println("Enter Food Name");
        String foodName = sc.nextLine();

        System.out.println("Enter Food Cost");
        String foodCost = sc.nextLine();

        return new NonVegfood(foodName, foodCost);
    }
    
    public static VegFood vegfoodInputs() {
        sc.nextLine();
        
        System.out.println("Enter Food Name");
        String foodName = sc.nextLine();

        System.out.println("Enter Food Cost");
        String foodCost = sc.nextLine();

        return new VegFood(foodName, foodCost);
    }

    public static BookingRoom bookingRoomInputs() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer ID:");
        Long customerId = sc.nextLong();  // Corrected variable name

        // Fetch customer from the database
        CustomerDao customerDAO = new CustomerDaoImpl();
        Optional<Customers> customerOptional = customerDAO.findById(customerId);
        if (!customerOptional.isPresent()) {
            System.out.println("Customer not found!");
            return null; // Handle this situation as needed
        }
        Customers customer = customerOptional.get(); // Use the Customer object

        sc.nextLine(); // Consume the leftover newline

        System.out.println("Enter Room Id:");
        Long roomNumber = sc.nextLong();

        // Fetch room from the service
        RoomService roomService = new RoomServiceImpl(); // Make sure RoomServiceImpl is instantiated correctly
        Room room = roomService.getRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Room not found!");
            return null;
        }

        sc.nextLine();
        LocalDate checkInDate = LocalDate.now();
        sc.nextLine();
        System.out.println("Enter Check-out Date (yyyy-MM-dd):");
        String checkOutDateString = sc.nextLine();
        LocalDate checkOutDate;
        try {
            checkOutDate = LocalDate.parse(checkOutDateString, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format!");
            return null; // Handle invalid date format
        }

        // Create and return a new BookingRoom instance
        return new BookingRoom(customer, room, checkInDate, checkOutDate);
    }

    // Operations methods for each entity

    public static void roomOperations()
    {
    	while(true) {
    		System.out.println("Press 1.Add Room Details\nPress 2.Retrieve All Room Data\n"
    				+ "Press 3.Update Room Data\nPress 4.Delete Room Data\n"
    				+ "Press 5.To getback to the main menu");
    		int input=sc.nextInt();	
    		
    		switch(input) {
    		case 1:
    			Room room=roomInputs();
    			Room savedEntity=roomService.createRoom(room);
    			System.out.println("Room Data has been saved successfully"+ savedEntity);
    			break;
    		
    		case 2:
    			List<Room> rooms=roomService.getAllRooms();
    			for(Room stud:rooms)
    			{
    				System.out.println(stud);
    			}
    			break;
    			
    		case 3:
    			sc.nextLine();
                System.out.println("Enter Room ID to Update:");
                Long roomId = sc.nextLong();
                Room existingRoom = roomService.getRoomByNumber(roomId);
                if (existingRoom != null) {
                	Room updatedroom = roomInputs();
                	Room updated = roomService.updateRoom(roomId, updatedroom);
                    System.out.println("Room updated successfully: " + updated);
                } else {
                    System.out.println("Room not found");
                }
                break;
    		
    		case 4:
    			System.out.println("Enter Room Id to delete the infromation");
    		    Long id=sc.nextLong();
    		    roomService.deleteRoom(id);
    		    System.out.println("Room Deleted Successfully");
    			break;
    		case 5:
    			MainOperation.mainOps();
    			break;
    		}
    		
    		}
    	
    }
   
	public static Customers updatedCustomersData()
    {
    	sc.nextLine();
    	
    	System.out.println("Enter Customer Name");
    	String cust_name=sc.nextLine();
    	
    	System.out.println("Enter Gender");
    	String gender=sc.nextLine();
    	
    	System.out.println("Enter Customer Number");
    	String custNumber=sc.nextLine();
    	
    	sc.nextLine();
    	System.out.println("Enter  Deposit Amount");
    	String deposit=sc.nextLine();
    	sc.nextLine();
    	System.out.println("Enter Customer Country");
    	String country=sc.nextLine();
    	
    	System.out.println("Enter CheckinTime ");
    	String dateString = "2024-08-07";
    	LocalDate date = LocalDate.parse(dateString);

    	
    	
    	return new Customers(cust_name, gender, custNumber,deposit,country,date);
    			
    	}

	public static Room updatedRoomData()
    {
    	sc.nextLine();
    	
    	System.out.println("Enter Room Number");
    	String roomnumber=sc.nextLine();

    	System.out.println("Enter Room Availability");
    	String availability=sc.nextLine();
    	
    	System.out.println("Enter Clean Status");
    	String cleanstatus=sc.nextLine();
    	
    	System.out.println("Enter Price");
    	String price=sc.nextLine();
    	System.out.println("Enter Bed Type");
    	String bedtype=sc.nextLine();

    	    	return new Room(roomnumber, availability, cleanstatus, price,bedtype);
    			
    	}


    public static void customerOperations() {
        while (true) {
            System.out.println("Press 1.Add Customer\nPress 2.Retrieve All Customers\n"
                    + "Press 3.Update Customer\nPress 4.Delete Customer\nPress 5.To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Customers customer = customerInputs();
                    Customers savedCustomer = customerService.createCustomer(customer);
                    System.out.println("Customer added successfully: " + savedCustomer);
                    break;

                case 2:
                    List<Customers> customers = customerService.getAllCustomers();
                    for (Customers c : customers) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                	 sc.nextLine();
                     System.out.println("Enter Customer ID to update:");
                     Long custId = sc.nextLong();
                     Customers existingDriver = customerService.getCustomer(custId);
                     if (existingDriver != null) {
                    	 Customers updatedDriver = customerInputs();
                    	 Customers updated = customerService.updateCustomer(custId, updatedDriver);
                         System.out.println("Customer updated successfully: " + updated);
                     } else {
                         System.out.println("Customer not found");
                     }
                     break;

                case 4:
                	 System.out.println("Enter Customer ID to delete:");
                     Long deleteCustomerId = sc.nextLong();
                     customerService.deleteCustomer(deleteCustomerId);
                     System.out.println("Customer deleted successfully");
                     break;

                case 5:
                    MainOperation.mainOps();
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void driverOperations() {
        while (true) {
            System.out.println("Press 1.Add Driver\nPress 2.Retrieve All Drivers\n"
                    + "Press 3.Update Driver\nPress 4.Delete Driver\nPress 5.To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Drivers driver = driverInputs();
                    Drivers savedDriver = driverService.createDriver(driver);
                    System.out.println("Driver added successfully: " + savedDriver);
                    break;

                case 2:
                    List<Drivers> drivers = driverService.getAllDrivers();
                    for (Drivers d : drivers) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Enter Driver ID to update:");
                    Long driverId = sc.nextLong();
                    Drivers existingDriver = driverService.getDriverById(driverId);
                    if (existingDriver != null) {
                        Drivers updatedDriver = driverInputs();
                        Drivers updated = driverService.updateDriver(driverId, updatedDriver);
                        System.out.println("Driver updated successfully: " + updated);
                    } else {
                        System.out.println("Driver not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Driver ID to delete:");
                    Long deleteDriverId = sc.nextLong();
                    Long deleteMessage = driverService.deleteDriver(deleteDriverId);
                    System.out.println(deleteMessage);
                    break;

                case 5:
                    MainOperation.mainOps();
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void employeeOperations() {
        while (true) {
            System.out.println("Press 1.Add Employee\nPress 2.Retrieve All Employees\n"
                    + "Press 3.Update Employee\nPress 4.Delete Employee\nPress 5.To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Employees employee = employeeInputs();
                    Employees savedEmployee = employeeService.createEmployee(employee);
                    System.out.println("Employee added successfully: " + savedEmployee);
                    break;

                case 2:
                    List<Employees> employees = employeeService.getAllEmployees();
                    for (Employees e : employees) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                	sc.nextLine();
                    System.out.println("Enter Employee ID to update:");
                    Long empId = sc.nextLong();
                    Employees existingDriver = employeeService.getEmployeeByAadhar(empId);
                    if (existingDriver != null) {
                    	Employees updatedEmployees = employeeInputs();
                    	Employees updated = employeeService.updatedEmployee(empId, updatedEmployees);
                        System.out.println("Employees updated successfully: " + updated);
                    } else {
                        System.out.println("Employees not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter Employee ID to delete:");
                    Long deleteEmployeeId = sc.nextLong();
                    Long deleteMessage = employeeService.deleteEmployee(deleteEmployeeId);
                    System.out.println(deleteMessage);
                    break;

                case 5:
                    MainOperation.mainOps();
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void departmentOperations() {
        while (true) {
            System.out.println("Press 1.Add Department\nPress 2.Retrieve All Departments\n"
                    + "Press 3.Update Department\nPress 4.Delete Department\nPress 5.To get back to the main menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Department department = departmentInputs();
                    Department savedDepartment = departmentService.createDepartment(department);
                    System.out.println("Department added successfully: " + savedDepartment);
                    break;

                case 2:
                    List<Department> departments = departmentService.getAllDepartments();
                    for (Department d : departments) {
                        System.out.println(d);
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("Enter Department ID to update:");
                    Long departmentId = sc.nextLong();
                    Department existingDepartment = departmentService.getDepartmentById(departmentId);
                    if (existingDepartment != null) {
                        Department updatedDepartment = departmentInputs();
                        Department updated = departmentService.updateDepartment(departmentId, updatedDepartment);
                        System.out.println("Department updated successfully: " + updated);
                    } else {
                        System.out.println("Department not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Department ID to delete:");
                    Long deleteDepartmentId = sc.nextLong();
                    Long deleteMessage = departmentService.deleteDepartment(deleteDepartmentId);
                    System.out.println(deleteMessage);
                    break;

                case 5:
                    MainOperation.mainOps();
                    return;

                default:
                    System.out.println("Invalid input");
            }
        }
    }
    public static void foodTypeSelection() {
        while (true) {
            System.out.println("Select Food Type:\n1. Veg\n2. Non-Veg\n3. Other Operation");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    vegfoodOperations();
                    break;
                case 2:
                    nonvegfoodOperations();
                    break;
                case 3:
                    System.out.println("Other Operation...");
                    return;  // Exit the loop and the application
                default:
                    System.out.println("Invalid input. Please select 1, 2, or 3.");
            }
        }
    }

    public static void vegfoodOperations() {
        while (true) {
            System.out.println("Veg Food Operations:\n1. Add VegFood\n2. Retrieve All VegFood Items\n"
                    + "3. Update VegFood\n4. Delete VegFood\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); 

            switch (input) {
                case 1:
                    VegFood food = vegfoodInputs(); 
                    VegFood savedFood = vegfoodService.addVegFood(food);
                    System.out.println("Food added successfully: " + savedFood);
                    break;

                case 2:
                    List<VegFood> foods = vegfoodService.getAllVegFoods();
                    if (foods.isEmpty()) {
                        System.out.println("No VegFood items found.");
                    } else {
                        for (VegFood f : foods) {
                            System.out.println(f);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Food ID to update:");
                    Long foodId = sc.nextLong();
                    sc.nextLine(); 
                    VegFood existingFood = vegfoodService.getVegFoodById(foodId);
                    if (existingFood != null) {
                        VegFood updatedFood = vegfoodInputs();
                        vegfoodService.updateVegFood(foodId,updatedFood);
                        System.out.println("Food updated successfully.");
                    } else {
                        System.out.println("Food not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Food ID to delete:");
                    Long deleteFoodId = sc.nextLong();
                    sc.nextLine();  // Consume newline
                    vegfoodService.deleteVegFood(deleteFoodId); // Correct method call
                    System.out.println("Food deleted successfully.");
                    break;

                case 5:
                    return;  // Exit the loop to go back to the food type selection

                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void nonvegfoodOperations() {
        while (true) {
            System.out.println("Non-Veg Food Operations:\n1. Add NonVegFood\n2. Retrieve All NonVegFood Items\n"
                    + "3. Update NonVegFood\n4. Delete NonVegFood\n5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (input) {
                case 1:
                    NonVegfood food = nvegfoodInputs(); // Ensure this method is defined
                    nvegfoodService.addNonVegFood(food); // Correct method call
                    System.out.println("Food added successfully: " + food);
                    break;

                case 2:
                    List<NonVegfood> foods = nvegfoodService.getAllNonVegFoods();
                    if (foods.isEmpty()) {
                        System.out.println("No NonVegFood items found.");
                    } else {
                        for (NonVegfood f : foods) {
                            System.out.println(f);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Food ID to update:");
                    Long foodId = sc.nextLong();
                    sc.nextLine();  // Consume newline
                    NonVegfood existingFood = nvegfoodService.getNonVegFoodById(foodId);
                    if (existingFood != null) {
                        NonVegfood updatedFood = nvegfoodInputs(); // Ensure this method is defined
                        nvegfoodService.updateNonVegFood(foodId,updatedFood); // Correct method call
                        System.out.println("Food updated successfully.");
                    } else {
                        System.out.println("Food not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Food ID to delete:");
                    Long deleteFoodId = sc.nextLong();
                    sc.nextLine();  // Consume newline
                    nvegfoodService.deleteNonVegFood(deleteFoodId); // Correct method call
                    System.out.println("Food deleted successfully.");
                    break;

                case 5:
                    return;  // Exit the loop to go back to the food type selection

                default:
                    System.out.println("Invalid input");
            }
        }
    }


    public static void bookingRoomOperations() {
        while (true) {
            System.out.println("Press 1.Add Booking\nPress 2.Retrieve All Bookings\n"
                    + "Press 3.Update Booking\nPress 4.Delete Booking\nPress 5.To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
            case 1:
                BookingRoom bookingRoom = bookingRoomInputs();
                bookingRoomService.createBookingRoom(bookingRoom);
                System.out.println("Booking added successfully: " + bookingRoom);
                break;

            case 2:
                List<BookingRoom> bookings = bookingRoomService.getAllBookingRooms();
                for (BookingRoom b : bookings) {
                    System.out.println(b);
                }
                break;

            case 3:
                System.out.println("Enter Booking ID to update:");
                Long bookingId = sc.nextLong();
                BookingRoom existingBooking = bookingRoomService.getBookingRoomById(bookingId).orElse(null);
                if (existingBooking != null) {
                    BookingRoom updatedBooking = bookingRoomInputs();
                    updatedBooking.setBookingId(bookingId); // Ensure the ID is set for update
                    bookingRoomService.updateBookingRoom(updatedBooking);
                    System.out.println("Booking updated successfully: " + updatedBooking);
                } else {
                    System.out.println("Booking not found");
                }
                break;

            case 4:
                System.out.println("Enter Booking ID to delete:");
                Long deleteBookingId = sc.nextLong();
                bookingRoomService.deleteBookingRoom(deleteBookingId);
                System.out.println("Booking deleted successfully");
                break;

            case 5:
                MainOperation.mainOps();
                return;

            default:
                System.out.println("Invalid input");
            }
        }
    }
    
}
