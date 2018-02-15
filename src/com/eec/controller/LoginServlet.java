package com.eec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Employee;
import com.eec.service.EmployeeService;
import com.eec.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String userpsw = request.getParameter("userpsw");
		EmployeeService service = new EmployeeServiceImpl();
		Employee employee = service.login(username, userpsw);
		if (employee != null) {
			request.getSession().setAttribute("CURRENT_USER", employee);
			
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
			//登陆成功以后，重定向到获取雇员列表的Servlet里面去
			response.sendRedirect("list");
		}
	}

}
