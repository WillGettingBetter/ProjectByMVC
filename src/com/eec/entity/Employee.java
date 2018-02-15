package com.eec.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8660335248285010329L;

	private int employeeId;
	private String loginId;
	private String loginPwd;
	private Date birth;
	private String email;
	private String realName;
	private String phone;
	private String address;

	// 查询表的数据，可以使用添加辅助列的方式来实现
	private String deptName;
	private int deptId;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String loginId, String loginPwd, Date birth, String email, String realName,
			String phone, String address, String deptName, int deptId) {
		super();
		this.employeeId = employeeId;
		this.loginId = loginId;
		this.loginPwd = loginPwd;
		this.birth = birth;
		this.email = email;
		this.realName = realName;
		this.phone = phone;
		this.address = address;
		this.deptName = deptName;
		this.deptId = deptId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}
