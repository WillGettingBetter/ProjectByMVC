package com.eec.entity;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 可序列化，确保安全性和稳定性
	 */
	private static final long serialVersionUID = 216584840286001611L;

	private int deptId;
	private String deptName;
	private String deptLoc;
	private int parentId;

	public Department() {
		super();
	}

	public Department(int deptId, String deptName, String deptLoc, int parentId) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLoc=" + deptLoc + ", parentId="
				+ parentId + "]";
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
