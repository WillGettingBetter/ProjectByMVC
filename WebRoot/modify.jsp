<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.eec.entity.Employee"%>
<%@page import="com.eec.entity.Department"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
table {
	width: 500px;
	height: 400px;
	text-align: center;
	border: 1px solid red;
	margin: 0 auto;
	border-collapse: collapse;
	border: 1px solid red;
}

table tr td {
	border: 1px solid red;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<%
		Employee employee = (Employee) request.getAttribute("emp");
	%>
	<form action="do_update" method="post">
		<table>
			<caption>新增雇员</caption>
			<tr>
				<td>登录名</td>
				<input type="hidden" name="employeeId"
					value="<%=employee.getEmployeeId()%>" />
				<td><input type="text" name="loginId"
					value="<%=employee.getLoginId()%>" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="loginPwd"
					value="<%=employee.getLoginPwd()%>" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<%
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				%>
				<td><input id="d121" type="text" name="birth"
					value="<%=sdf.format(employee.getBirth())%>"
					onclick="WdatePicker({isShowWeek:true})" /></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" name="email"
					value="<%=employee.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" name="realName"
					value="<%=employee.getRealName()%>" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone"
					value="<%=employee.getPhone()%>" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="address"
					value="<%=employee.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>所属部门</td>
				<td><select name="deptId" value="<%=employee.getDeptName()%>">
						<%
							List<Department> list = (List<Department>) request.getAttribute("dList");
							for (int i = 0; i < list.size(); i++) {
						%>
						<option <%if (list.get(i).getDeptId() == employee.getDeptId()) {%>
							selected="selected" <%}%> value="<%=list.get(i).getDeptId()%>"><%=list.get(i).getDeptName()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新" /></td>
			</tr>
		</table>
	</form>
</body>
</html>