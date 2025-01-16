package com.jsp.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class Display extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-servlet-jdbc", "root", "root");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");
			
			ResultSet resultSet =preparedStatement.executeQuery();
			
			req.setAttribute("Data", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("showEmployee.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
	}

}
