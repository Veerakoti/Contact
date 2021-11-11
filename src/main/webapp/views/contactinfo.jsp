<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
  $( function() {
    $( "#dob" ).datepicker();
  } );
  
  </script>
	<script>
	$(document).ready(function(e) {
	
    $(".email").blur(function(event) {
     alert('response=='Duplicate');
     $("#dupEmail").html("");
       var emailId=$(".email").val();
         $.ajax({
                    url: '/validateEmail?email=' + emailId,
                    success: function(response) {
                    if(response=='Duplicate'){
                     $("#dupEmail").html("Email already registred");
                      $(".email").focus();
                      }
                    }
                });
                });
    });
  </script>


<script src="js/App.js"></script>

</head>
<body>


	<h2>my first program</h2>
	<p>
		<font color="green">${success}</font>
	</p>
	<p>
		<font color='red'>${error}</font>
	</p>
	<form:form action="userAccReg" modelAttribute="contact" method="POST">
		<table>
			<tr>
				<form:hidden path="regid" />
				<td>first name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>last name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" class="email" />
				<font color='red'><div id="dupEmail"></div></font></td>

			</tr>
			<tr>
				<td>Mobile :</td>
				<td><form:input path="mobile" /></td>
			</tr>
			<tr>
				<td>DOB</td>
				<%-- <td><form:input id="datepicker" path="dob" /></td> --%>
				<td><form:input path="dob" id="dob" /></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><form:radiobutton path="gender" value="M" id="gender" />Male
					<form:radiobutton path="gender" value="F" id="gender" />Female</td>
			</tr>
			<tr>
				<th>Country :</th>
				<td><form:select path="entity" class="entity">
						<form:option value="">-Select-</form:option>
						<form:options items="${countrys}" />
					</form:select></td>
			</tr>
			<tr>
				<th>State :</th>
				<td><form:select path="stateEntity" class="stateEntity">
						<form:option value="">-Select-</form:option>
					</form:select></td>
			</tr>
			<tr>
				<th>City :</th>
				<td><form:select path="cityEntity">
						<form:option value="">-Select-</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Save"></td>
			</tr>

		</table>

	</form:form>
	<a href="viewContacts">view contacts</a>
</body>
</html>