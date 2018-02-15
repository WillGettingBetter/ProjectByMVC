package com.eec.service;

import java.util.List;

import com.eec.entity.Employee;

/**
 * 
 * <p>
 * Class Name: EmployeeServices.java
 * </p>
 * <p>
 * Description: 业务逻辑层
 * </p>
 * 
 * @author 舒家峰 DateTime 2018年2月3日 下午5:06:50
 * @company 安徽科技学院
 * @email 1185577383@qq.com
 * @version 1.0
 */
public interface EmployeeService {

	/**
	 * 登录需要登录名和登录密码
	 * 
	 * @param loginId
	 *            登录名
	 * @param loginPwd
	 *            登录密码
	 * @return 返回的是Employee对象
	 */
	public Employee login(String loginId, String loginPwd);

	/**
	 * 分页查询，返回对象列表
	 * 
	 * @param pageSize
	 *            页容量，也就是每一页显示几个雇员的信息
	 * @param pageIndex
	 *            页索引，也就是当前第几页
	 * @return 返回的是每一页的雇员列表
	 */
	public List<Employee> getEmployeeByPage(int pageSize, int pageIndex);

	/**
	 * 返回总页数
	 * 
	 * @param pageSize
	 *            页容量
	 * @return 返回总页数
	 */
	public int getTotalPages(int pageSize);

	/**
	 * 新增雇员
	 * 
	 * @param employee
	 *            雇员对象
	 * @return 返回数据表受影响的行数
	 */
	public int register(Employee employee);

	/**
	 * 通过employeeId删除雇员信息
	 * 
	 * @param employeeId
	 *            雇员Id
	 * @param selfId
	 *            自己的Id
	 * @return 返回数据表受影响的行数
	 */
	public int deleteEmp(int employeeId, int selfId);

	/**
	 * 通过employeeId获取到对应的对象
	 * 
	 * @param employeeId
	 *            雇员编号
	 * @return 返回雇员对象
	 */
	public Employee showEmployeeById(int employeeId);

	/**
	 * 更新数据库中的雇员信息
	 * 
	 * @param employee
	 *            雇员信息
	 * @return 返回受影响的行数
	 */
	public int modifyEmp(Employee employee);
}
