package com.eec.service.impl;

import java.util.List;

import com.eec.dao.EmployeeDao;
import com.eec.dao.impl.EmployeeDaoImpl;
import com.eec.entity.Employee;
import com.eec.service.EmployeeService;

/**
 * 
 * <p>
 * Class Name: EmployeeServiceImpl.java
 * </p>
 * <p>
 * Description:业务逻辑层实现层
 * </p>
 * 
 * @author 舒家峰 DateTime 2018年2月3日 下午5:16:08
 * @company 安徽科技学院
 * @email 1185577383@qq.com
 * @version 1.0
 */
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao empDao = new EmployeeDaoImpl();

	@Override
	public Employee login(String loginId, String loginPwd) {
		Employee employee = empDao.getEmployeeByLoginId(loginId);
		if (employee == null) {// 根据登录名什么都没查询到
			return null;
		} else if (employee.getLoginPwd().equals(loginPwd)) {
			return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeByPage(int pageSize, int pageIndex) {
		return empDao.getEmployeeByPage(pageSize, pageIndex);
	}

	@Override
	public int getTotalPages(int pageSize) {
		return empDao.getPageCount(pageSize);
	}

	@Override
	public int register(Employee employee) {
		// 首先根据登录名查询
		Employee emp = empDao.getEmployeeByLoginId(employee.getLoginId());
		if (emp == null) {
			// 可以新增
			int res = empDao.addEmp(employee);
			if (res > 0) {
				// 新增成功
				return res;
			} else {
				// 新增失败
				return 0;
			}
		} else {
			// 该登录名已经存在
			return -1;
		}
	}

	@Override
	public int deleteEmp(int employeeId, int selfId) {
		if (employeeId != selfId) {
			int res = empDao.deleteEmp(employeeId);
			if (res > 0) {
				return res;
			}
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public Employee showEmployeeById(int employeeId) {
		return empDao.getEmployeeById(employeeId);
	}

	@Override
	public int modifyEmp(Employee employee) {
		return empDao.updateEmp(employee);
	}

}
