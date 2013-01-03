
<%@ page import="com.mb.domain.FUsers" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'FUsers.label', default: 'FUsers')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-FUsers" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-FUsers" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list FUsers">
			
				<g:if test="${FUsersInstance?.alias}">
				<li class="fieldcontain">
					<span id="alias-label" class="property-label"><g:message code="FUsers.alias.label" default="Alias" /></span>
					
						<span class="property-value" aria-labelledby="alias-label"><g:fieldValue bean="${FUsersInstance}" field="alias"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.ptsDelta}">
				<li class="fieldcontain">
					<span id="ptsDelta-label" class="property-label"><g:message code="FUsers.ptsDelta.label" default="Pts Delta" /></span>
					
						<span class="property-value" aria-labelledby="ptsDelta-label"><g:fieldValue bean="${FUsersInstance}" field="ptsDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.ptsTotal}">
				<li class="fieldcontain">
					<span id="ptsTotal-label" class="property-label"><g:message code="FUsers.ptsTotal.label" default="Pts Total" /></span>
					
						<span class="property-value" aria-labelledby="ptsTotal-label"><g:fieldValue bean="${FUsersInstance}" field="ptsTotal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.rank}">
				<li class="fieldcontain">
					<span id="rank-label" class="property-label"><g:message code="FUsers.rank.label" default="Rank" /></span>
					
						<span class="property-value" aria-labelledby="rank-label"><g:fieldValue bean="${FUsersInstance}" field="rank"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.rankDelta}">
				<li class="fieldcontain">
					<span id="rankDelta-label" class="property-label"><g:message code="FUsers.rankDelta.label" default="Rank Delta" /></span>
					
						<span class="property-value" aria-labelledby="rankDelta-label"><g:fieldValue bean="${FUsersInstance}" field="rankDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.rankTeam}">
				<li class="fieldcontain">
					<span id="rankTeam-label" class="property-label"><g:message code="FUsers.rankTeam.label" default="Rank Team" /></span>
					
						<span class="property-value" aria-labelledby="rankTeam-label"><g:fieldValue bean="${FUsersInstance}" field="rankTeam"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.rankTeamDelta}">
				<li class="fieldcontain">
					<span id="rankTeamDelta-label" class="property-label"><g:message code="FUsers.rankTeamDelta.label" default="Rank Team Delta" /></span>
					
						<span class="property-value" aria-labelledby="rankTeamDelta-label"><g:fieldValue bean="${FUsersInstance}" field="rankTeamDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.teamId}">
				<li class="fieldcontain">
					<span id="teamId-label" class="property-label"><g:message code="FUsers.teamId.label" default="Team Id" /></span>
					
						<span class="property-value" aria-labelledby="teamId-label"><g:fieldValue bean="${FUsersInstance}" field="teamId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.timestamp}">
				<li class="fieldcontain">
					<span id="timestamp-label" class="property-label"><g:message code="FUsers.timestamp.label" default="Timestamp" /></span>
					
						<span class="property-value" aria-labelledby="timestamp-label"><g:fieldValue bean="${FUsersInstance}" field="timestamp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.wuDelta}">
				<li class="fieldcontain">
					<span id="wuDelta-label" class="property-label"><g:message code="FUsers.wuDelta.label" default="Wu Delta" /></span>
					
						<span class="property-value" aria-labelledby="wuDelta-label"><g:fieldValue bean="${FUsersInstance}" field="wuDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FUsersInstance?.wuTotal}">
				<li class="fieldcontain">
					<span id="wuTotal-label" class="property-label"><g:message code="FUsers.wuTotal.label" default="Wu Total" /></span>
					
						<span class="property-value" aria-labelledby="wuTotal-label"><g:fieldValue bean="${FUsersInstance}" field="wuTotal"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${FUsersInstance?.id}" />
					<g:link class="edit" action="edit" id="${FUsersInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
