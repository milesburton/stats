<%@ page import="com.mb.domain.FTeams" %>



<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'alias', 'error')} ">
	<label for="alias">
		<g:message code="FTeams.alias.label" default="Alias" />
		
	</label>
	<g:textField name="alias" maxlength="199" value="${FTeamsInstance?.alias}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'timestamp', 'error')} ">
	<label for="timestamp">
		<g:message code="FTeams.timestamp.label" default="Timestamp" />
		
	</label>
	<g:field name="timestamp" type="number" value="${FTeamsInstance.timestamp}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'ptsDelta', 'error')} required">
	<label for="ptsDelta">
		<g:message code="FTeams.ptsDelta.label" default="Pts Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsDelta" type="number" value="${FTeamsInstance.ptsDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'ptsTotal', 'error')} required">
	<label for="ptsTotal">
		<g:message code="FTeams.ptsTotal.label" default="Pts Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsTotal" type="number" value="${FTeamsInstance.ptsTotal}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'rank', 'error')} required">
	<label for="rank">
		<g:message code="FTeams.rank.label" default="Rank" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rank" type="number" value="${FTeamsInstance.rank}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'rankDelta', 'error')} required">
	<label for="rankDelta">
		<g:message code="FTeams.rankDelta.label" default="Rank Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rankDelta" type="number" value="${FTeamsInstance.rankDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'teamId', 'error')} required">
	<label for="teamId">
		<g:message code="FTeams.teamId.label" default="Team Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="teamId" type="number" value="${FTeamsInstance.teamId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'wuDelta', 'error')} required">
	<label for="wuDelta">
		<g:message code="FTeams.wuDelta.label" default="Wu Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wuDelta" type="number" value="${FTeamsInstance.wuDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FTeamsInstance, field: 'wuTotal', 'error')} required">
	<label for="wuTotal">
		<g:message code="FTeams.wuTotal.label" default="Wu Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wuTotal" type="number" value="${FTeamsInstance.wuTotal}" required=""/>
</div>

