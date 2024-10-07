package carConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carConnect.entity.Admin;
import carConnect.exception.AdminNotFoundException;
import carConnect.util.*;

public class AdminService implements IAdminService{
	static Connection con;
	private static void getCon() throws SQLException{
		if(con==null)
			con= DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
	}
	
	
	@Override
	public Admin getAdminByID(int adminID) throws SQLException, AdminNotFoundException{
		getCon();
		Admin obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where customerId=?");
			pstmt.setInt(1, adminID);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Admin(
						 res.getInt("Admin ID"), res.getString("FirstName"), 
						 res.getString("LastName"), 
						 res.getString("Email"), 
						 res.getString("PhoneNumber"),  
						 res.getString("Username"), 
						 res.getString("Password"),
						 res.getString("Role"), 
						 res.getDate("Join Date"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return obj;
	}

	@Override
	public Admin getAdminByUsername(String username) throws SQLException, AdminNotFoundException {
		getCon();
		Admin obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where Username=?");
			pstmt.setString(1, username);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Admin(0, res.getString("FirstName"), 
						 res.getString("LastName"), 
						 res.getString("Email"), 
						 res.getString("PhoneNumber"),  
						 res.getString("Username"), 
						 res.getString("Password"),
						 res.getString("Role"), null);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return obj;
	}

	@Override
	public void registerAdmin(Admin admin) throws SQLException {
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("insert into Customer(FirstName, LastName, Email, PhoneNumber, Username, Password, Role) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());
		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row Inserted Successfully.");
		    }
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAdmin(Admin admin) throws SQLException, AdminNotFoundException {
		getCon();
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("update Customer set FirstName=?, LastName=?, Email=?, PhoneNumber=?, Username=?, Password=?, Role=?");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());
		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row updated successfully!");
		    }
		    
			
	}catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Error while Updating in Customer table!");
		}
		
	}

	@Override
	public void deleteAdmin(int adminID) throws SQLException, AdminNotFoundException {
		getCon();
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("delete from Customer where adminId=?");
			pstmt.setInt(1, adminID); 		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row Deleted successfully!");
		    }
		    
			
	}catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Error while deleting in Customer table!");
		}
	}
	
}
