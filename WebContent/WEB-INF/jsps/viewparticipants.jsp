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
		
		<h1><s:text name="text.participants"/> ${sessionScope.titulo}</h1>
		<h3><s:text name="text.participants.promotor"/> ${sessionScope.promotor}</h3>
		
		<table>
			<tr>
				<td><s:text name="tabla.share.id"/></td>
				<td><s:text name="tabla.share.idProyecto"/></td>
				<td><s:text name="tabla.share.idAccionista"/></td>
				<td><s:text name="tabla.share.dinero"/></td>
				<td><s:text name="tabla.share.pendiente"/></td>
			</tr>
				<s:iterator id="participantsshareproject" value="%{#application.participantslist}">
							
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="idProyecto" /></td>
						<td><s:property value="idAccionario" /></td>
						<td><s:property value="dinero" /></td>
						<td><s:property value="pendiente" /></td>
					</tr>
				</s:iterator>
		</table>
	
	</section>
	
	<s:a action="ParticipateProject"><s:text name="back"/></s:a>

	<jsp:include page="common/footer.jsp" />

</body>

</html>