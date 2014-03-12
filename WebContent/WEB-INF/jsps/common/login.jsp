<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.miw.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="login">	
	<ul id="login">
		<% 
		String user= null;
		User u = (User)request.getSession().getAttribute("usuario");
		if(u != null)	
			user = u.getLogin();
		if (user==null) { %>
		 	<li><s:a action="Register"><s:text name="register"/></s:a><br/></li>
			<li>|</li>
			<li><s:a action="Login"><s:text name="loguear"/></s:a></li>
		<% } else { %>
		 	<li><s:a action="UnLogin"><s:text name="out"/></s:a><br/></li>
		 	<li>|</li>
		 	<li>${sessionScope.usuario.getLogin()}</li>
		 	<li><img alt="<s:text name="nav_login.photo.alt"/>" src="img/user.png"><li>
		<% } %>
	</ul>
</div>