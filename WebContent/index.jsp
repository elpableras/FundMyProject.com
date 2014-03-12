<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="WEB-INF/jsps/common/login.jsp" />
<jsp:include page="WEB-INF/jsps/common/head.jsp" />

<body>

	<jsp:include page="WEB-INF/jsps/common/header.jsp" />
	<jsp:include page="WEB-INF/jsps/nav/nav_index.jsp" />

	<section>
		<h1><s:text name="welcome"/></h1>
		<img alt="<s:text name="index.photo.alt"/>" src="img/businessangel.gif">
		<h3><s:text name="text.projects"/></h3>
	</section>

	<jsp:include page="WEB-INF/jsps/common/footer.jsp" />

</body>

</html>