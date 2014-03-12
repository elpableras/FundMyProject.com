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
	<jsp:include page="nav/nav_view_project.jsp" />

	<section>
		<h1><s:text name="welcome"/> ${sessionScope.usuario.getLogin()}</h1>
		<h3><s:text name="text.projects"/></h3>
		<table>
			<tr>
				<td><s:text name="tabla.titulo"/></td>
				<td><s:text name="tabla.descripcion"/></td>
				<td><s:text name="tabla.coste"/></td>
				<td><s:text name="tabla.fecha"/></td>
				<td><s:text name="tabla.promotor"/></td>
				<td><s:text name="tabla.porcentajeF"/></td>
				<td><s:text name="tabla.maxusuarios"/></td>
			</tr>
		
			<s:iterator id="project" value="%{#application.projectlist}">
				<tr>
					<td><s:property value="titulo" /></td>
					<td><s:property value="descripcion" /></td>
					<td><s:property value="coste" /></td>
					<td><s:property value="fecha" /></td>
					<td><s:property value="promotor" /></td>
					<td><s:property value="porcentaje" /></td>
					<td><s:property value="users" /></td>
				</tr>
			</s:iterator>
		</table>
	</section>

	<jsp:include page="common/footer.jsp" />

</body>

</html>

