<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<br>
	<c:choose>
		<c:when test="${sessionScope.name != null}">
			<h1>Name : ${sessionScope.name}</h1>
			<h1>Role : ${sessionScope.role}</h1>
			<h2>
				Welcome : ${sessionScope.name} | <a
					href="<c:url value="/j_spring_security_logout" />"> Logout</a>
			</h2>
		</c:when>
		<c:otherwise>
			<h2>
				<a href="login.htm">Go to login page</a>
			</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>