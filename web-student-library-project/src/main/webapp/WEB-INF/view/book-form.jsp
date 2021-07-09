<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Book</title>

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
			<h2>WBA - Web Book Application</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Book</h3>
	
		<form:form action="saveBook" modelAttribute="book" method="POST">
		
		<!-- need to associate this data with customer id -->
		<form:hidden path="bookId"/>
			<table>
				<tbody>
					<tr>
						<td><label>Subject:</label></td>
						<td><form:input path="subject" /></td>
					</tr>
				
					<tr>
						<td><label>Author:</label></td>
						<td><form:input path="author" /></td>
					</tr>

					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
					
					<tr>
						<td><label>Year:</label></td>
						<td><form:input path="year" /></td>
					</tr>
					
					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company" /></td>
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
			<a href="${pageContext.request.contextPath}/list/listBook">Back to List</a>
		</p>
	
	</div>

</body>

</html>










