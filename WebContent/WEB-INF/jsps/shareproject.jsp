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
	<jsp:include page="nav/nav_share_project.jsp" />

	<section>
		<h1><s:text name="text.share"/> ${sessionScope.usuario.getLogin()}</h1>
	
		<table>
			<tr>
				<td><s:text name="tabla.share.id"/></td>
				<td><s:text name="tabla.share.idProyecto"/></td>
				<td><s:text name="tabla.share.idAccionista"/></td>
				<td><s:text name="tabla.share.dinero"/></td>
				<td><s:text name="tabla.share.pendiente"/></td>
			</tr>
				<s:iterator id="shareproject" value="%{#application.sharelist}">
							
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="idProyecto" /></td>
						<td><s:property value="idAccionario" /></td>
						<td><s:property value="dinero" /></td>
						<td><s:property value="pendiente" /></td>
					</tr>
				</s:iterator>
		</table>
		
		<s:form action="Share">
			<s:select name="addedPending" key="text.share.label" list="%{#application.pendinglist}" listKey="id" listValue="id" />
			<s:submit key="text.share.submit" name="submit"/>
		</s:form>
	</section>

	<jsp:include page="common/footer.jsp" />

</body>

</html>