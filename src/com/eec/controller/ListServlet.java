package com.eec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eec.entity.Employee;
import com.eec.service.EmployeeService;
import com.eec.service.impl.EmployeeServiceImpl;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 到service里面得到雇员列表
		EmployeeService service = new EmployeeServiceImpl();
		int pageIndex = 1;
		int pageSize = 3;
		// 首先获取pageIndex和pageSize
		if (request.getParameter("pageIndex") != null) {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		int pageCount = service.getTotalPages(pageSize);

		List<Employee> list = service.getEmployeeByPage(pageSize, pageIndex);

		// 将其传入jsp页面
		if (list.size() > 0) {
			// 将雇员列表存入request作用域中。
			request.setAttribute("elist", list);
			// 把页码传递到jsp页面中
			request.setAttribute("pageIndex", pageIndex);
			// 把总页数传递到jsp页面中
			request.setAttribute("pageCount", pageCount);
			// 转发
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}

	}

}
