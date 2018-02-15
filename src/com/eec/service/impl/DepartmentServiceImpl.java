package com.eec.service.impl;

import java.util.List;

import com.eec.dao.DepartmentDao;
import com.eec.dao.impl.DepartmentDaoImpl;
import com.eec.entity.Department;
import com.eec.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao deptDao = new DepartmentDaoImpl();

	@Override
	public List<Department> showDepartments() {
		return deptDao.getDepartmentsAll();
	}

}
