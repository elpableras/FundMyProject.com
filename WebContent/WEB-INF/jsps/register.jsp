<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java" 
	import="impl.miw.presentation.*,java.util.Vector,java.sql.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="common/login.jsp" />
<jsp:include page="common/head.jsp" />

<body>

	<jsp:include page="common/header.jsp" />
	<jsp:include page="nav/nav_login.jsp" />

	<section>
		<h1><s:text name="text.register"/></h1>
	
		<s:form action="Register">
			<s:textfield key="text.login.user" name="login"/>
			<s:password key="text.login.password" name="password"/>
			<s:submit key="text.register.submit" name="submit"/>
		</s:form>

	</section>

	<jsp:include page="common/footer.jsp" />

</body>

</html>