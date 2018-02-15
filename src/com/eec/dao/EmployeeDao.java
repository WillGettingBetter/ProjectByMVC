package com.eec.dao;

import java.util.List;

import com.eec.entity.Employee;

public interface EmployeeDao {

	/**
	 * 根据雇员编号查询雇员信息
	 * 
	 * @param empId
	 *            雇员编号
	 * @return 返回Employee对象
	 */
	public Employee getEmployeeById(int empId);

	/**
	 * 分页显示雇员信息
	 * 
	 * @param pageSize
	 *            页容量，也就是每一页显示几个雇员的信息
	 * @param pageIndex
	 *            页索引，也就是当前第几页
	 * @return 返回的是每一页的雇员列表
	 */
	public List<Employee> getEmployeeByPage(int pageSize, int pageIndex);

	/**
	 * 根据雇员登录名查询雇员信息
	 * 
	 * @param loginId
	 *            登录名
	 * @return 返回Employee对象
	 */
	public Employee getEmployeeByLoginId(String loginId);

	/**
	 * 求出总页数
	 * 
	 * @param pageSize
	 *            页容量
	 * @return 返回总页数
	 */
	public int getPageCount(int pageSize);

	/**
	 * 新增雇员
	 * 
	 * @param employee
	 *            雇员对象
	 * @return 返回数据表受影响的行数
	 */
	public int addEmp(Employee employee);

	/**
	 * 通过employeeId删除雇员信息
	 * 
	 * @param employeeId
	 *            雇员的Id
	 * @return 返回数据表受影响的行数
	 */
	public int deleteEmp(int employeeId);

	/**
	 * 通过employee对象来更新数据库中的信息
	 * 
	 * @param employee
	 *            雇员对象
	 * @return 返回数据库表受影响的行数
	 */
	public int updateEmp(Employee employee);
}
