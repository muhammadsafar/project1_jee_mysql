package com.dreamlearnpath.msbahrddin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamlearnpath.msbahrddin.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class ProccessServlet
 */
@WebServlet("/ProccessServlet")
public class ProccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProccessServlet() {
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
		String url = "/Display.jsp";
		String name = request.getParameter("name");
		String nip = request.getParameter("nip");
		String age = request.getParameter("age");

		// insert to database
		updateDB(name, nip, age);

		Employee emp = new Employee(name, nip, Integer.parseInt(age), true);

		request.setAttribute("emp", emp);

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	protected void updateDB(String name, String nip, String age) {

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
			String query = "INSERT INTO `employee` (`id`, `name`, `nip`, `age`, `isActive`) VALUES (NULL, '" + name
					+ "', '" + nip + "', '" + age + "', '1')";

			s.executeUpdate(query);

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
