<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function more(item) {
		$(item).before("<input type=\"text\" name=\"strings\"/>");
	}
	$(function () {
		if ("${msg==null}"=="false") {
			alert("${msg}");
		}
	});
</script>
</head>
<body>
	<h1>Redis测试</h1>${msg }
	<div>
		<a href="<%=request.getContextPath()%>/get.do?key=qinshi">获取string值</a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/lget.do?key=l2">获取list值</a>
	</div>
	<div>
		<form action="<%=request.getContextPath() %>/add.do" method="post">
		名字：<input type="text" name="key"/>
		值：<input type="text" name="value"/>
		<input type="submit" value="添加"> 
	</form>
	</div>
	
	<div>
		<form action="<%=request.getContextPath() %>/lpush.do" method="post">
			名字：<input type="text" name="key"/>
			值：<input type="text" name="strings"/>
			<input type="text" name="strings"/>
			<input type="button" value="更多" onclick="more(this)"/>
			<input type="submit" value="添加">
		</form>
	</div>
	<div>
		<form action="<%=request.getContextPath() %>/del.do" method="post">
			名字：<input type="text" name="key"/>
			<input type="submit" value="删除">
		</form>
	</div>
	<table>
		<tr>
			<td>${val }</td>
		</tr>
	</table>
	
	<table>
		<tr>
			<c:forEach var="value" items="${list }">
				<td>${value }</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>