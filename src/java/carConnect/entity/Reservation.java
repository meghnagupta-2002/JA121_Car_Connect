package java.carConnect.entity;

import java.util.Date;

public class Reservation {
	// Properties of Reservation Class
	private int reservationID;
    private int customerID;
    private int vehicleID;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private String status;

    // Default constructor
    public Reservation() {
    	super();
    }

    // Parameterized constructor
    public Reservation(int reservationID, int customerID, int vehicleID, Date startDate, Date endDate, double totalCost, String status) {
        this.reservationID = reservationID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }
    
 // Getters and Setters
    
  //--------- ReservationID--------------------------------------
    public int getReservationID() {
        return reservationID;
    }
    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

  //--------- CustomerID--------------------------------------
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
  //--------- VehicleID--------------------------------------
    public int getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

  //--------- StartDate--------------------------------------
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

  //--------- EndDate--------------------------------------
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

  //--------- TotalCost--------------------------------------
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

  //--------- Status--------------------------------------
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

  // Calculate Total Cost
    public double calculateTotalCost(double dailyRate) {
        long duration = endDate.getTime() - startDate.getTime();
        long days = duration / (1000 * 60 * 60 * 24); 
        return days * dailyRate;
    }

}
