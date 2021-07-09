<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Information</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>WLA - Web Library Application</h2>
		</div>
	</div>

	<div id="container">
		<h3>Student Information</h3>
	
		<form:form action="saveStudent" modelAttribute="student" method="POST">
		
		<!-- need to associate this data with student id -->
		<form:hidden path="studentId"/>
			<table>
				<tbody>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
				
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>

					<tr>
						<td><label>Street:</label></td>
						<td><form:input path="street" /></td>
					</tr>
					
					<tr>
						<td><label>Post Code:</label></td>
						<td><form:input path="postCode" /></td>
					</tr>
					
					<tr>
						<td><label>City:</label></td>
						<td><form:input path="city" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/list/listStudent">Back to List</a>
		</p>
	
	</div>

</body>

</html>










