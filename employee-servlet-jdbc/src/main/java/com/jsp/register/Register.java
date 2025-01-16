package com.jsp.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet("/register")
public class Register extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//reading from form and storing in variable
		String id=req.getParameter("user-id");
		String name=req.getParameter("user-name");
		String email=req.getParameter("user-email");
		String password=req.getParameter("user-password");
		String salary=req.getParameter("salary");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-servlet-jdbc","root","root");
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?)" );
			
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setDouble(5, Double.parseDouble(salary));
			preparedStatement.executeUpdate();
			connection.close();
			
			RequestDispatcher requestDispatcher= req.getRequestDispatcher("display.html");
			requestDispatcher.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
