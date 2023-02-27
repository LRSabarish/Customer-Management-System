package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess {
	
	private static final String dburl ="jdbc:mysql://localhost:3306/servlet";
	private static final String dbusername ="root";
	private static final String dbpassword ="sabarish";
	
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String qry="insert into customer (name,mobile,state,email,password) value (?,?,?,?,?)";
	
	public static boolean validation(String Email,String Password)
	{
		boolean b=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps=con.prepareStatement("select email,password from customer where email=? and password=?");
			ps.setString(1, Email);
			ps.setString(2, Password);
			rs=ps.executeQuery();
			
			b=rs.next();
			
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {


					e.printStackTrace();
				}
			}
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {


					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {


					e.printStackTrace();
				}
			}
		}
		return b;
	}
	
	
	public static void insertcustomer(Customer c)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps=con.prepareStatement(qry);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getMobile());
			ps.setString(3, c.getState());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getPassword());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {


					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {


					e.printStackTrace();
				}
			}
		}
	}
	

}
