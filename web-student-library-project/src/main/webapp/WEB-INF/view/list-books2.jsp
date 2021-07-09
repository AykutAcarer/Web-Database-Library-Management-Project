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
		
			<h2>WBA - Web Book Application</h2>
		
		</div>
	</div>
	
	
	<div id="container">
	
		<div id="content">
		
		<!-- put new button: Add Customer ------    BUNU OGRENCIYE KITAP EKLEMEK ICIN YAPABILIRIZ BOOKLIST CLASSINIA BIR METOD EKLE CONTROLLERE DA BENZER METOD VE DEVAM ET-->
		
		<input type="button" value="Add Book"
				onclick="window.location.href='listBooksForStudent'; return false;" 
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
					
						
						<!-- construct an "delete" link with book id" ----- BU DELETE LINKI KITABI VERI TABANINDAN SILMEK ICIN DEGIL OGRENCI UZERINDEN SILMEK ICIN OLSUN-->
						<c:url var="deletelink" value="/list/deleteBook">
							<c:param name="bookId" value="${tempBook.bookId}"/>
						</c:url>	
						
						
							<td> ${tempBook.bookId} </td>
							<td> ${tempBook.subject} </td>
							<td> ${tempBook.author} </td>
							<td> ${tempBook.title} </td>
							<td> ${tempBook.year} </td>
							<td> ${tempBook.company} </td>
							
							<td>
								<a href="${deletelink}"
								onclick="if (!(confirm('Are you sure deleting this item?')))return false">Delete</a>
								
						</tr>
						
					</c:forEach>
					
				</table>
					
		</div>
	
	</div>
	<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/list/listStudent">Back to List</a>
		</p>
	
	</div>
</body>

</html>