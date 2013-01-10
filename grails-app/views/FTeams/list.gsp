
<%@ page import="com.mb.domain.FTeams" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'FTeams.label', default: 'FTeams')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-FTeams" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-FTeams" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="alias" title="${message(code: 'FTeams.alias.label', default: 'Alias')}" />
					
						<g:sortableColumn property="timestamp" title="${message(code: 'FTeams.timestamp.label', default: 'Timestamp')}" />
					
						<g:sortableColumn property="ptsDay" title="${message(code: 'FTeams.ptsDay.label', default: 'Pts Day')}" />
					
						<g:sortableColumn property="ptsDelta" title="${message(code: 'FTeams.ptsDelta.label', default: 'Pts Delta')}" />
					
						<g:sortableColumn property="ptsTotal" title="${message(code: 'FTeams.ptsTotal.label', default: 'Pts Total')}" />
					
						<g:sortableColumn property="ptsWeek" title="${message(code: 'FTeams.ptsWeek.label', default: 'Pts Week')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${FTeamsInstanceList}" status="i" var="FTeamsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${FTeamsInstance.id}">${fieldValue(bean: FTeamsInstance, field: "alias")}</g:link></td>
					
						<td>${fieldValue(bean: FTeamsInstance, field: "timestamp")}</td>
					
						<td>${fieldValue(bean: FTeamsInstance, field: "ptsDay")}</td>
					
						<td>${fieldValue(bean: FTeamsInstance, field: "ptsDelta")}</td>
					
						<td>${fieldValue(bean: FTeamsInstance, field: "ptsTotal")}</td>
					
						<td>${fieldValue(bean: FTeamsInstance, field: "ptsWeek")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${FTeamsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
