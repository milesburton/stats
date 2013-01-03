
<%@ page import="com.mb.domain.FUsers" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'FUsers.label', default: 'FUsers')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-FUsers" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-FUsers" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="alias" title="${message(code: 'FUsers.alias.label', default: 'Alias')}" />
					
						<g:sortableColumn property="ptsDelta" title="${message(code: 'FUsers.ptsDelta.label', default: 'Pts Delta')}" />
					
						<g:sortableColumn property="ptsTotal" title="${message(code: 'FUsers.ptsTotal.label', default: 'Pts Total')}" />
					
						<g:sortableColumn property="rank" title="${message(code: 'FUsers.rank.label', default: 'Rank')}" />
					
						<g:sortableColumn property="rankDelta" title="${message(code: 'FUsers.rankDelta.label', default: 'Rank Delta')}" />
					
						<g:sortableColumn property="rankTeam" title="${message(code: 'FUsers.rankTeam.label', default: 'Rank Team')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${FUsersInstanceList}" status="i" var="FUsersInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${FUsersInstance.id}">${fieldValue(bean: FUsersInstance, field: "alias")}</g:link></td>
					
						<td>${fieldValue(bean: FUsersInstance, field: "ptsDelta")}</td>
					
						<td>${fieldValue(bean: FUsersInstance, field: "ptsTotal")}</td>
					
						<td>${fieldValue(bean: FUsersInstance, field: "rank")}</td>
					
						<td>${fieldValue(bean: FUsersInstance, field: "rankDelta")}</td>
					
						<td>${fieldValue(bean: FUsersInstance, field: "rankTeam")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${FUsersInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
