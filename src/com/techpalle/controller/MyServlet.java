package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		
		switch(path)
		{
		case"/logcus":
			validatecustomer(request,response);
		case "/regcustomer":
			insertcustomer(request,response);
			break;
		case "/log":
			getLoginPage(request,response);
			break;
		case "/reg":
			getReisterPage(request,response);
			break;
			
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	
	private void validatecustomer(HttpServletRequest request, HttpServletResponse response) {
		
		
			String e=request.getParameter("tbemail");
			String p=request.getParameter("tbpsw");
			
			boolean res=DataAccess.validation(e, p);
			if(res) 
			{
				try {
					 
					
					RequestDispatcher rd =request.getRequestDispatcher("success.jsp");
					SuccessPage sp=new SuccessPage();
					request.setAttribute("successDetails", sp);
					rd.forward(request, response);
				} catch (ServletException e2) {
					
					e2.printStackTrace();
				} catch (IOException e2) {
					
					e2.printStackTrace();
				}
		   }
			else
			{
				getLoginPage(request,response);
				
			}
			
	}


	private void insertcustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String n=request.getParameter("tbname");
		long m=Long.parseLong(request.getParameter("tbnum"));
		String s=request.getParameter("ddlstate");
		String e=request.getParameter("tbemail");
		String p=request.getParameter("tbpsw");
		
		Customer cus=new Customer(n,m,s,e,p);
		
//call insertcustomer method present in dao pakage and pass the above object variable		
		DataAccess.insertcustomer(cus);
		
		 try {
				
				RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} catch (ServletException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
	
	}


	private void getReisterPage(HttpServletRequest request, HttpServletResponse response) {
         try {
			
			RequestDispatcher rd =request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
        try {
			
			RequestDispatcher rd =request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			RequestDispatcher rd =request.getRequestDispatcher("customermanagement.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}


