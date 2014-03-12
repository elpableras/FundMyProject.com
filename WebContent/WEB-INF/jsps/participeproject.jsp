<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" language="java" 
	import="impl.miw.presentation.*,java.util.Vector,java.sql.*,com.miw.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="common/login.jsp" />
<jsp:include page="common/head.jsp" />

<body>

	<jsp:include page="common/header.jsp" />
	<jsp:include page="nav/nav_participe_project.jsp" />

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
				<td><s:text name="tabla.participes"/></td>
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
					<td><s:a action="View"><s:text name="tabla.participes"/><s:param name="idTitulo" value="titulo"/><s:param name="idPromotor" value="promotor"/></s:a></td>
				</tr>
			</s:iterator>
		</table>
	</section>
	
	<section>
	
	<h1><s:text name="text.participe"/>, ${sessionScope.usuario.getLogin()}</h1>
		
	<% User u = (User)request.getSession().getAttribute("usuario"); 
	   String user = u.getLogin(); %>
	   
	<s:set var="userName"><%=user%></s:set>

	<s:form action="Participe">
		<s:select name="addedProject" key="text.participe.label" list="%{#application.projectlist}" listKey="titulo" listValue="titulo" />
		<s:textfield key="text.participe.precio" name="dinero" />
		<s:hidden name="idAccionario" value="%{#userName}"/>
		<s:hidden name="pendiente" value="true"/>
		<s:submit key="text.participe.submit" name="submit"/>
	</s:form>
	
	</section>

	<jsp:include page="common/footer.jsp" />

</body>

</html>