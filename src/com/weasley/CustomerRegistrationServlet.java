package com.weasley;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet("/CustomerRegistration")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Our new Customer placeholder
		Customer customer = new Customer();
		
		// Extract, transform, and optionally validate the form data into the Customer
		String customerIdAsString = request.getParameter("customerId");
		Long customerId = -1L;
		customerId = Long.parseLong(customerIdAsString);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNumber = request.getParameter("phoneNumber");
		customer.setCustomerId(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setPhoneNumber(phoneNumber);
		System.out.println("Registered Customer: " + customer);
		
		// Now build up the response object to send to the browser.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); // java.io.PrintWriter
		out.println("<h1>Customer Registered!</h1>");
		out.println("Customer: " + customer);
		out.flush();
		out.close();
	}

}
