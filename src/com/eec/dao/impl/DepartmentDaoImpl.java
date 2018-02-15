package com.eec.dao.impl;

import java.util.List;

import com.eec.dao.DepartmentDao;
import com.eec.entity.Department;
import com.eec.util.DBUtils;

public class DepartmentDaoImpl implements DepartmentDao {

	private DBUtils dbUtils = new DBUtils();

	@Override
	/**
	 * 获取所有的部门
	 */
	public List<Department> getDepartmentsAll() {
		String sql = " SELECT deptId,deptName,deptLoc,parentId FROM department ";
		return dbUtils.getForList(Department.class, sql);
	}

}
