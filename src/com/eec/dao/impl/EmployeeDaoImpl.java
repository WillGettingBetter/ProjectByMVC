package com.eec.dao.impl;

import java.util.List;

import com.eec.dao.EmployeeDao;
import com.eec.entity.Employee;
import com.eec.util.DBUtils;
import com.eec.util.DateUtils;

public class EmployeeDaoImpl implements EmployeeDao {

	private DBUtils dbUtils = new DBUtils();

	@Override
	public Employee getEmployeeById(int empId) {
		StringBuilder sb = new StringBuilder(" SELECT * FROM employee WHERE employeeId=? ");
		return dbUtils.getForObject(Employee.class, sb.toString(), empId);
	}

	@Override
	/* 分页查询用户信息 */
	public List<Employee> getEmployeeByPage(int pageSize, int pageIndex) {
		StringBuilder sb = new StringBuilder();
		// sb.append("SELECT
		// employeeId,loginId,loginPwd,birth,email,realName,phone,address FROM
		// employee ");
		// 两表联查
		sb.append(" SELECT employeeId,loginId,loginPwd,birth,email,realName,phone,address,deptName,department.deptId ");
		sb.append("FROM employee INNER JOIN department ON employee.deptId=department.deptId order by employeeId desc ");
		sb.append("LIMIT ?,? ");
		Object[] objs = { (pageIndex - 1) * pageSize, pageSize };
		return dbUtils.getForList(Employee.class, sb.toString(), objs);
	}

	@Override
	public Employee getEmployeeByLoginId(String loginId) {
		StringBuilder sb = new StringBuilder(" SELECT * FROM employee WHERE loginId=? ");
		return dbUtils.getForObject(Employee.class, sb.toString(), loginId);
	}

	@Override
	public int getPageCount(int pageSize) {
		String sql = " select count(0) from employee ";
		Object obj = dbUtils.getForValue(sql);
		if (obj != null) {
			int count = Integer.parseInt(obj.toString());
			return count % pageSize == 0 ? count / pageSize : (count / pageSize + 1);
		}
		return 0;
	}

	@Override
	public int addEmp(Employee emp) {
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO employee(loginId,loginPwd,birth,email,realName,phone,address,deptId)  ");
		sb.append(" VALUES(?,?,?,?,?,?,?,?) ");
		Object[] objs = { emp.getLoginId(), emp.getLoginPwd(), DateUtils.utilDateTosqlDate(emp.getBirth()),
				emp.getEmail(), emp.getRealName(), emp.getPhone(), emp.getAddress(), emp.getDeptId() };
		return dbUtils.update(sb.toString(), objs);
	}

	@Override
	public int deleteEmp(int employeeId) {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from employee where employeeId=? ");
		return dbUtils.update(sb.toString(), employeeId);
	}

	@Override
	public int updateEmp(Employee employee) {
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE employee SET loginId=?, ");
		sb.append(" loginPwd=?,birth=?,email=?,realName=?, ");
		sb.append(" phone=?,address=?,deptId=? WHERE employeeId=? ");
		Object[] objs = { employee.getLoginId(), employee.getLoginPwd(),
				DateUtils.utilDateTosqlDate(employee.getBirth()), employee.getEmail(), employee.getRealName(),
				employee.getPhone(), employee.getAddress(), employee.getDeptId(), employee.getEmployeeId() };
		return dbUtils.update(sb.toString(), objs);
	}

}
