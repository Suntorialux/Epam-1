<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/libs/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	
	<jsp:useBean id="reader" class="by.gsu.epamlab.services.FileReader" />
	<c:set target="${reader}" property="fileName" value="${initParam.filename}" />
	<c:out value="${reader.type}"></c:out>
	<form name="testForm" ACTION="controller" method="POST" 
	 onClick="for(i=0;i<testForm.val.length;i++)testForm.flag[i].value=testForm.val[i].value;">
		<c:forEach  items="${reader.len}" var="inp">
			<input name="flag" type="checkbox" value="${inp}" />
			<c:choose>
  				<c:when test="${reader.type eq 'text'}">
     			 	<input name="val" type="text" value="${inp}" />
     			 	<br />
  				</c:when>
  				<c:when test="${param.age eq 'label'}">
  					
      				<label for="${inp}" >${inp}</label>
      				<br />
  				</c:when>
  				<c:otherwise>
    			 	${inp}<br />
 			 	</c:otherwise>
			</c:choose>
		</c:forEach>
		
		
		<input type=hidden name="select">
		<a href="JavaScript:sendForm('sum')">Sum</a>
		<a href="JavaScript:sendForm('min')">Min</a>
		<a href="JavaScript:sendForm('max')">Max</a>
		<a href="JavaScript:sendForm('avg')">Avg</a>
	</form>
	
	
	<script>
		function sendForm(sRef) {
			document.testForm.select.value=sRef;
			document.testForm.submit();
		}
	</script>
	<script src="resources/libs/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>