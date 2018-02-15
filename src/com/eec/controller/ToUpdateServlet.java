package com.eec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Department;
import com.eec.entity.Employee;
import com.eec.service.DepartmentService;
import com.eec.service.EmployeeService;
import com.eec.service.impl.DepartmentServiceImpl;
import com.eec.service.impl.EmployeeServiceImpl;

public class ToUpdateServlet extends HttpServlet {
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
		EmployeeService empService=new EmployeeServiceImpl();
		//通过雇员编号，获取雇员信息
		Employee emp=empService.showEmployeeById(employeeId);
		//得到部门列表
		DepartmentService deptService=new DepartmentServiceImpl();
		List<Department> dList=deptService.showDepartments();
		if(emp!=null&&dList.size()>0){
			request.setAttribute("emp", emp);
			request.setAttribute("dList", dList);
			request.getRequestDispatcher("modify.jsp").forward(request, response);
		}
	}

}
