package com.eec.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Department;
import com.eec.entity.Employee;
import com.eec.service.EmployeeService;
import com.eec.service.impl.EmployeeServiceImpl;
import com.eec.util.DateUtils;

public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		Date birth = DateUtils.strToUtilDate(request.getParameter("birth"));
		String email = request.getParameter("email");
		String realName = request.getParameter("realName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setBirth(birth);
		employee.setDeptId(deptId);
		employee.setEmail(email);
		employee.setLoginId(loginId);
		employee.setLoginPwd(loginPwd);
		employee.setPhone(phone);
		employee.setRealName(realName);

		EmployeeService empService = new EmployeeServiceImpl();
		int result = empService.register(employee);
		if (result > 0) {
			// 新增成功
			response.sendRedirect("list");
		} else if (result == -1) {
			// 用户名已经存在
		} else {
			// 新增失败
		}
	}

}
