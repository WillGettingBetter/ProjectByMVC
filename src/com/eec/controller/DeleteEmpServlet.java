package com.eec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Employee;
import com.eec.service.EmployeeService;
import com.eec.service.impl.EmployeeServiceImpl;

public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		// 通过employeeId执行删除
		EmployeeService empService = new EmployeeServiceImpl();
		Employee employee = (Employee) request.getSession().getAttribute("CURRENT_USER");
		int res = empService.deleteEmp(employeeId, employee.getEmployeeId());
		if (res > 0) {
			response.sendRedirect("list");
		} else {
			// 删除失败
			System.out.println("删除失败");
		}
	}

}
