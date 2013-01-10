
<%@ page import="com.mb.domain.FTeams" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'FTeams.label', default: 'FTeams')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-FTeams" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-FTeams" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list FTeams">
			
				<g:if test="${FTeamsInstance?.alias}">
				<li class="fieldcontain">
					<span id="alias-label" class="property-label"><g:message code="FTeams.alias.label" default="Alias" /></span>
					
						<span class="property-value" aria-labelledby="alias-label"><g:fieldValue bean="${FTeamsInstance}" field="alias"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.timestamp}">
				<li class="fieldcontain">
					<span id="timestamp-label" class="property-label"><g:message code="FTeams.timestamp.label" default="Timestamp" /></span>
					
						<span class="property-value" aria-labelledby="timestamp-label"><g:fieldValue bean="${FTeamsInstance}" field="timestamp"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.ptsDay}">
				<li class="fieldcontain">
					<span id="ptsDay-label" class="property-label"><g:message code="FTeams.ptsDay.label" default="Pts Day" /></span>
					
						<span class="property-value" aria-labelledby="ptsDay-label"><g:fieldValue bean="${FTeamsInstance}" field="ptsDay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.ptsDelta}">
				<li class="fieldcontain">
					<span id="ptsDelta-label" class="property-label"><g:message code="FTeams.ptsDelta.label" default="Pts Delta" /></span>
					
						<span class="property-value" aria-labelledby="ptsDelta-label"><g:fieldValue bean="${FTeamsInstance}" field="ptsDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.ptsTotal}">
				<li class="fieldcontain">
					<span id="ptsTotal-label" class="property-label"><g:message code="FTeams.ptsTotal.label" default="Pts Total" /></span>
					
						<span class="property-value" aria-labelledby="ptsTotal-label"><g:fieldValue bean="${FTeamsInstance}" field="ptsTotal"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.ptsWeek}">
				<li class="fieldcontain">
					<span id="ptsWeek-label" class="property-label"><g:message code="FTeams.ptsWeek.label" default="Pts Week" /></span>
					
						<span class="property-value" aria-labelledby="ptsWeek-label"><g:fieldValue bean="${FTeamsInstance}" field="ptsWeek"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.rank}">
				<li class="fieldcontain">
					<span id="rank-label" class="property-label"><g:message code="FTeams.rank.label" default="Rank" /></span>
					
						<span class="property-value" aria-labelledby="rank-label"><g:fieldValue bean="${FTeamsInstance}" field="rank"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.rankDelta}">
				<li class="fieldcontain">
					<span id="rankDelta-label" class="property-label"><g:message code="FTeams.rankDelta.label" default="Rank Delta" /></span>
					
						<span class="property-value" aria-labelledby="rankDelta-label"><g:fieldValue bean="${FTeamsInstance}" field="rankDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.teamId}">
				<li class="fieldcontain">
					<span id="teamId-label" class="property-label"><g:message code="FTeams.teamId.label" default="Team Id" /></span>
					
						<span class="property-value" aria-labelledby="teamId-label"><g:fieldValue bean="${FTeamsInstance}" field="teamId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.wuDelta}">
				<li class="fieldcontain">
					<span id="wuDelta-label" class="property-label"><g:message code="FTeams.wuDelta.label" default="Wu Delta" /></span>
					
						<span class="property-value" aria-labelledby="wuDelta-label"><g:fieldValue bean="${FTeamsInstance}" field="wuDelta"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${FTeamsInstance?.wuTotal}">
				<li class="fieldcontain">
					<span id="wuTotal-label" class="property-label"><g:message code="FTeams.wuTotal.label" default="Wu Total" /></span>
					
						<span class="property-value" aria-labelledby="wuTotal-label"><g:fieldValue bean="${FTeamsInstance}" field="wuTotal"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${FTeamsInstance?.id}" />
					<g:link class="edit" action="edit" id="${FTeamsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
