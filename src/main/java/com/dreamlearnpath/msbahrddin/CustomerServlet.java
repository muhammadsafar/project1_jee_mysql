package com.dreamlearnpath.msbahrddin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamlearnpath.msbahrddin.model.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/CustomerPage.jsp";
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", fname)) {
			url = "/CustomerForm.jsp";
			fname = "Try Again";
		}

		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", lname)) {
			url = "/CustomerForm.jsp";
			lname = "Try Again";
		}

		if (!regexChecker("^[A-Za-z0-9\\.\\' \\-]{2,30}$", street)) {
			url = "/CustomerForm.jsp";
			street = "Try Again";
		}

		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", city)) {
			url = "/CustomerForm.jsp";
			city = "Try Again";
		}

		if (!regexChecker("^[A-Za-z\\.\\' \\-]{2,30}$", state)) {
			url = "/CustomerForm.jsp";
			state = "Try Again";
		}

		if (!regexChecker("^[0-9\\.\\' \\-]{2,10}$", zipcode)) {
			url = "/CustomerForm.jsp";
			zipcode = "Try Again";
		}

		if (!regexChecker("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email)) {
			url = "/CustomerForm.jsp";
			email = "Try Again";
		}

		if (!regexChecker("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", password)) {
			url = "/CustomerForm.jsp";
			password = "Try Again";
		}

		if (!regexChecker("^[0-9\\.\\' \\-]{2,16}$", phone)) {
			url = "/CustomerForm.jsp";
			phone = "Try Again";
		}

		if (!url.equals("/CustomerForm.jsp")) {
			// insert to database
			updateDB(fname, lname, street, city, state, zipcode, email, password, phone);
		}

		Customer cus = new Customer(fname, lname, street, city, state, zipcode, email, password, phone);

		request.setAttribute("cus", cus);

		getServletContext().getRequestDispatcher(url).forward(request, response);

	}

	protected void updateDB(String fname, String lname, String street, String city, String state, String zipcode,
			String email, String password, String phone) {

		System.out.println("cek here service");

		Connection con;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/project_jee";
			String user = "root";
			String pw = "";
			con = DriverManager.getConnection(url, user, pw);

			System.out.println("connected...");

			Statement s = con.createStatement();
			String query = "INSERT INTO `customer` (`id`, `fname`, `lname`, `street`, `city`, `state`, `zipcode`, `email`, `password`, `phone`) VALUES (NULL, '"
					+ fname + "', '" + lname + "', '" + street + "', '" + city + "', '" + state + "', '" + zipcode
					+ "', '" + email + "', '" + password + "', '" + phone + "')";

			s.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	static boolean regexChecker(String regex, String str2Check) {

		Pattern regPattern = Pattern.compile(regex);

		Matcher regexMatcer = regPattern.matcher(str2Check);
		if (regexMatcer.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
