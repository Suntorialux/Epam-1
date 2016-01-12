<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="reader" class="by.gsu.epamlab.services.FileReader" />
	<c:set target="${reader}" property="fileName" value="${initParam.filename}" />
	
	<form name="test2" ACTION="controller">
		<c:forEach  items="${reader.len}" var="inp">
			<input name="flag" type="checkbox" value="${inp}">&nbsp;
			${inp}<br>
		</c:forEach>
		<INPUT TYPE="SUBMIT" NAME="go" VALUE="Go">
	</form>
	
	
</body>
</html>