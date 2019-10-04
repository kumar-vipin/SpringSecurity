<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <h1>Name : ${name}</h1>
    <h1>Description : ${description}</h1>
 
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    <%=request.getSession().getAttribute("name") %>
    <%=request.getSession().getAttribute("role") %>
          <h2>
            Welcome : ${sessionScope.name} (${sessionScope.role}) | 
            <a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
        </h2>
    </c:if>
</body>
</html>
