<html>
<head>
<title>IIHT Training Assignment SPRING WebMVC</title>
<style type="text/css">
body {
	background-color: #f7f7f7;
}
</style>
</head>
<body>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


	<div align="center">
		<br> <br>
		<h3 style="color: blue;">${message}</h3>
		<br> <br> 
		
		<c:if test="${not empty book}">
			<table border="1">
				<tr>
					<th> Book Id</th>
					<th> Book Title</th>
					<th> Price</th>
					<th> Volume</th>
					<th> Publish Date</th>
				</tr>
				<tr>
					<td> <c:out value="${book.bookId}"></c:out>   </td>
					<td> <c:out value="${book.title}"></c:out>   </td>
					<td> <c:out value="${book.price}"></c:out>   </td>
					<td> <c:out value="${book.volume}"></c:out>   </td>
					<td> <c:out value="${book.publishDate}"></c:out>   </td>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${not empty subject}">
			<table border="1">
				<tr>
					<th> Subject Id </th>
					<th> Subject Title </th>
					<th> Duration In hours</th>
				</tr>
				<tr>
					<td> <c:out value="${subject.subjectId}"></c:out>   </td>
					<td> <c:out value="${subject.subjectTitle}"></c:out>   </td>
					<td> <c:out value="${subject.durationInHours}"></c:out>   </td>
				</tr>
			</table>
		</c:if>
		
		
		<br> <br> Click <a
			href="http://localhost:8080/home">Here</a> to go back.
	</div>
	<br>
	<br>
</body>
</html>