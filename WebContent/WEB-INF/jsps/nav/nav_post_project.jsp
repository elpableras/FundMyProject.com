<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav>
	<ul>
		<li><s:a action="SeekProjects"><s:text name="nav.view.project"/></s:a></li>
		<li><p><s:text name="nav.post.project"/></p></li>
		<li><s:a action="ParticipateProject"><s:text name="nav.participe.project"/></s:a></li>
		<li><s:a action="ShareholderProject"><s:text name="nav.share.project"/></s:a></li>
	</ul>
</nav>