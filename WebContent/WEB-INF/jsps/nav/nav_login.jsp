<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav>
	<ul>
		<li>
			<s:a action="Index"><s:text name="nav.index"/></s:a>
		</li>
		<li><s:a action="SeekProjects"><s:text name="nav.view.project"/></s:a></li>
	</ul>
</nav>