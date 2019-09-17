<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="vo.Department"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>部门管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles/common03.css" />

	</head>

	<body>
		<div class="page-content">
			<div class="content-nav">
				人员管理 > 部门管理
			</div>
			<form onsubmit="return validate()" action="DepartmentFindServlet"
				method="post">
				<input type="hidden" name="code" value="add">
				<fieldset>
					<legend>
						添加部门
					</legend>

					部门名称:
					<input type="text" id="departmentname" name="departmentname"
						maxlength="20" />
					<input type="submit" class="clickbutton" value="添加" />
				</fieldset>
			</form>

			<table class="listtable">
				<caption>
					所有部门:
				</caption>
				<tr class="listheader">
					<th>
						部门编号
					</th>
					<th>
						部门名称
					</th>
					<th>
						操作
					</th>

					<tr>
						<td>
							1
						</td>
						<td>
							技术部
						</td>
						<td>
							<a class="clickbutton"
								onclick="window.location.href='departmentedit.jsp';">编辑</a>
							<a class="clickbutton" href="">删除</a>
						</td>
					</tr>
					<tr>
						<td>
							2
						</td>
						<td>
							财务部
						</td>
						<td>
							<a class="clickbutton" href="">编辑</a>
							<a class="clickbutton" href="">删除</a>
						</td>
					</tr>
			</table>
		</div>
	</body>
</html>
