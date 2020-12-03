<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<jsp:include page="_head.jsp">
    <jsp:param name="title" value="Artist page" />
</jsp:include>
<body>
    <h1><c:out value="${ artist.getName() }" /></h1>
    
    <c:if test="${ !albums.isEmpty() }">
	    <table>
	        <tr><th>Album name</th></tr>
	        
		    <c:forEach var="album" items="${ albums }">
		        <tr>
		          <td><c:out value="${ album.getTitle() }" /></td>
		        </tr>
		    </c:forEach>
	    </table>
    </c:if>
    <c:if test="${ albums.isEmpty() }">
        <div>No albums for this artist :(</div>
    </c:if>

</body>
</html>