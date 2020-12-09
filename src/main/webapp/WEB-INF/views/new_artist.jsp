<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp">
    <jsp:param value="Create a new artist" name="title" />
</jsp:include>
<body>
    <h1>Create a new artist</h1>

    <c:if test="${ error != null }">
        <p>Error: <c:out value="${ error }"/></p>
    </c:if>

    <form method="post" action="/artist/new">
        <label>
            Name: 
            <input type="text" name="artistName" />
        </label>
        <input type="submit" value="Save" />
    </form>
</body>
</html>