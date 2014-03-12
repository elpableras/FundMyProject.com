<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.miw.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<footer>
	<p>
		<a href="http://validator.w3.org/"> <img
			src="http://www.w3.org/html/logo/downloads/HTML5_1Color_White.png"
			width="90" height="64" alt="<s:text name="footer.photo.alt1"/>"
			title="<s:text name="footer.photo.title1"/>">
		</a> <a href="http://jigsaw.w3.org/css-validator/"> <img
			style="border: 0; width: 88px; height: 31px"
			src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
			alt="<s:text name="footer.photo.alt2"/>" title="<s:text name="footer.photo.title2"/>" />
		</a>
	</p>
	<p>
		<small><s:text name="footer.small"/></small>
	</p>
	<p><small>© copyright <a href="mailto:UO173780@uniovi.es">Pablo González Jiménez</a> 2013 MIW-DASW</small></p>
	<% 
	String user= null;
	User u = (User)request.getSession().getAttribute("usuario");
	if(u != null)	
		user = u.getLogin();
	   if (user!=null) { %>
	 	<p><small><s:text name="footer.visitas"/>: <s:property value="%{#application.counter}" /></small></p>
	<% } %>

</footer>