<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Contact Details</title>
<link
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
	function confirmDelete() {
		return confirm("Are you sure to delete?");
	}
</script>
</head>
<h2>all contacts list</h2>
<a href="addContact">+Add Contact</a>
<br>
<br>
<body>

	<table border="1" id="contactTbl">
		<thead>
			<tr>
				<th>S.no</th>
				<th>Contact Name</th>
				<th>Contact Email</th>
				<th>Contact Number</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?cid=${c.contactId}">Edit</a>| <a
						href="deleteContact?cid=${c.contactId}"
						onclick="return confirmDelete()">Delete</a></td>

				</tr>

			</c:forEach>

		</tbody>
	</table>
</body>
</html>