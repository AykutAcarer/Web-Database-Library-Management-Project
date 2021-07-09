<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>

<title>List Books</title>

<!--  reference our style sheet -->

<link type="text/css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

	<div id="wrapper">
		<div id ="header">
		
			<h2>WLA - Book List</h2>
		
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
		<!-- put new button: Add Customer -->
		<input type="button" value="Add Book"
				onclick="window.location.href='showFormForAddBook'; return false;" 
				class="add-button"
				/>
		
			<!--  add out html table here -->
				<table>
					<tr>
						<th>Nu</th>
						<th>Subject</th>
						<th>Author</th>
						<th>Title</th>
						<th>Year</th>
						<th>Company</th>
						<th>Action</th>
					</tr>
					
					<!-- loop over and print our customers -->
					<c:forEach var="tempBook" items="${books}">
					
						
						<!-- construct an "delete" link with book id" -->
						<c:url var="deletelink" value="/list/deleteBook">
							<c:param name="bookId" value="${tempBook.bookId}"/>
						</c:url>	
						
						<!-- construct an "link" link with book id" -->
						<c:url var="link" value="/list/linkForStudentFromStudent">
							<c:param name="bookId" value="${tempBook.bookId}"/>
						</c:url>	
						<tr>
						
							<td> ${tempBook.bookId} </td>
							<td> ${tempBook.subject} </td>
							<td> ${tempBook.author} </td>
							<td> ${tempBook.title} </td>
							<td> ${tempBook.year} </td>
							<td> ${tempBook.company} </td>
							
							<td>
								<a href="${deletelink}"
								onclick="if (!(confirm('Are you sure deleting this item?')))return false">Delete</a>
								|
								<a href="${link}">Student</a>
						</tr>
						
					</c:forEach>
					
				</table>
					
		</div>
	
	</div>

</body>

</html>