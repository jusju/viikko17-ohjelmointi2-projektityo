<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="Front page" />
</jsp:include>
<body>

	<h1>Welcome</h1>

    <jsp:include page="_searchForm.jsp" />

	<ul>
		<c:forEach var="artist" items="${ artists }">
			<li><a href="artist?id=${ artist.getId() }"> <c:out
						value="${ artist.getName() }" />
			</a></li>
		</c:forEach>
	</ul>
</body>
</html>