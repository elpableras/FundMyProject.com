<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.miw.model.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav>
	<ul>
		<% 
		String user= null;
		User u = (User)request.getSession().getAttribute("usuario");
		if(u != null)	
			user = u.getLogin();
	   if (user==null) { %>
	 	<li><s:a action="Index"><s:text name="nav.index"/></s:a></li>
		<li><p><s:text name="nav.view.project"/></p></li>
	   <% } else { %>
	 	<li><p><s:text name="nav.view.project"/></p></li>
		<li><s:a action="PostProject"><s:text name="nav.post.project"/></s:a></li>
		<li><s:a action="ParticipateProject"><s:text name="nav.participe.project"/></s:a></li>
		<li><s:a action="ShareholderProject"><s:text name="nav.share.project"/></s:a></li>
	   <% } %>
	</ul>
</nav>