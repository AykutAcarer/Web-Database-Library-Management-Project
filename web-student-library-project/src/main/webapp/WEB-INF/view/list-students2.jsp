<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

<title>List Students</title>

<!--  reference our style sheet -->

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

	<div id="wrapper">
		<div id ="header">
		
			<h2>WLA - Student List</h2>
		
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
		<!-- put new button: Add Student -->
		<input type="button" value="Add Student"
				onclick="window.location.href='showFormForAdd'; return false;" 
				class="add-button"
				/>
		
			<!--  add out html table here -->
				<table>
					<tr>
						<th>Nu</th>
						<th>Last Name</th>
						<th>First Name</th>
						<th>Street</th>
						<th>Post Code</th>
						<th>City</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our customers -->
					<c:forEach var="tempStudent" items="${students}">
						
							
						<!-- construct an "deletelink" link with student id" -->
						<c:url var="deletelink" value="/list/delete">
							<c:param name="studentId" value="${tempStudent.studentId}"/>
						</c:url>	

						<tr>
						
							<td> ${tempStudent.studentId} </td>
							<td> ${tempStudent.lastName} </td>
							<td> ${tempStudent.firstName} </td>
							<td> ${tempStudent.street} </td>
							<td> ${tempStudent.postCode} </td>
							<td> ${tempStudent.city} </td>
							
							<td>
								
								<a href="${deletelink}"
								onclick="if (!(confirm('Are you sure deleting this item?')))return false">Delete</a>
								
								
								
						</tr>
						
					</c:forEach>
					
				</table>
					
		</div>
	
	</div>

</body>

</html>