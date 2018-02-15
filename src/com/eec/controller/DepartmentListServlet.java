package com.eec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Department;
import com.eec.service.DepartmentService;
import com.eec.service.impl.DepartmentServiceImpl;

public class DepartmentListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3391127580977844539L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService deptService=new DepartmentServiceImpl();
		List<Department> deptList=deptService.showDepartments();
		if(deptList.size()>0){
			request.setAttribute("deptList", deptList);
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}

}
