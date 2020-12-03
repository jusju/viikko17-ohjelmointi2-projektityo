<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="Search" />
</jsp:include>
<body>
    <h1>Search</h1>

    <jsp:include page="_searchForm.jsp" />

    <ul>
        <c:forEach var="album" items="${ albums }">
	    	<li><c:out value="${ album.getTitle() }" /></li>
        </c:forEach>
    </ul>
</body>
</html>