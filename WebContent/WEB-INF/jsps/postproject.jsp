<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java" 
	import="impl.miw.presentation.*,com.miw.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="common/login.jsp" />
<jsp:include page="common/head.jsp" />

<body>

	<jsp:include page="common/header.jsp" />
	<jsp:include page="nav/nav_post_project.jsp" />

	<section>
		<h1><s:text name="text.post.project"/></h1>
		<h3><s:text name="text.post.data.project"/></h3>
	
		<% User u = (User)request.getSession().getAttribute("usuario"); 
		   String user = u.getLogin(); %>
		   
		<s:set var="userName"><%=user%></s:set>
	
		<s:form action="Post">
			<s:textfield key="text.post.titulo" name="titulo"/>
			<s:textarea key="text.post.descri" name="descripcion" cols="40" rows="10"/>
			<s:textfield key="text.post.coste" name="coste"/>
			<s:textfield key="text.post.time" name="fecha"/>
			<s:textfield key="text.post.promotor" name="promotor" value="%{#userName}" />
			<s:textfield key="text.post.porcentaje" name="porcentaje" value="0.0"/>
			<s:submit key="text.post.submit" name="submit"/>
		</s:form>
	</section>

	<jsp:include page="common/footer.jsp" />

</body>

</html>

