<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function validatePwds(){
    alert('calling function');
    var newPwds=$('#newPwd').val();
    var cnfPwds=$('#cnfPwd').val();
     alert('calling function'+newPwds+cnfPwds);
    if(newPwds!=cnfPwds){
     alert('true function');
      $('#errId').text('New pass & old pass not matching');
    return false;
    }
   
    return true;
    }
</script>


</head>
<body>
	<p>
		<font color="green">${success}</font>
	</p>
	<p>
		<font color='red'>${error}</font>
	</p>

	<h2>unlocking account</h2>
	<font color="red"><span id="errId"></span></font>
	<form:form action="unlockaccUser" modelAttribute="unlock" method="POST">
		<table>
			<tr>
				<td>Email</td>
				<td><form:input path="email" readonly="true"/></td>
			</tr>
			<tr>
				<td>Temp pwd :</td>
				<td><form:input path="tempPwd" /></td>
			</tr>
			<tr>
				<td>new pwd</td>
				<td><form:input path="newPwd" class="newPwd" /></td>
			</tr>
			<tr>
				<td>Cnf Pwd</td>
				<td><form:input path="cnfPwd" class="cnfPwd" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Unlock"
					onclick="javascript:return validatePwds()" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>