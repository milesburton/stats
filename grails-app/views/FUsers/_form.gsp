<%@ page import="com.mb.domain.FUsers" %>



<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'alias', 'error')} ">
	<label for="alias">
		<g:message code="FUsers.alias.label" default="Alias" />
		
	</label>
	<g:textField name="alias" maxlength="199" value="${FUsersInstance?.alias}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'ptsDay', 'error')} required">
	<label for="ptsDay">
		<g:message code="FUsers.ptsDay.label" default="Pts Day" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsDay" type="number" value="${FUsersInstance.ptsDay}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'ptsDelta', 'error')} required">
	<label for="ptsDelta">
		<g:message code="FUsers.ptsDelta.label" default="Pts Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsDelta" type="number" value="${FUsersInstance.ptsDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'ptsTotal', 'error')} required">
	<label for="ptsTotal">
		<g:message code="FUsers.ptsTotal.label" default="Pts Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsTotal" type="number" value="${FUsersInstance.ptsTotal}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'ptsWeek', 'error')} required">
	<label for="ptsWeek">
		<g:message code="FUsers.ptsWeek.label" default="Pts Week" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ptsWeek" type="number" value="${FUsersInstance.ptsWeek}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'rank', 'error')} required">
	<label for="rank">
		<g:message code="FUsers.rank.label" default="Rank" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rank" type="number" value="${FUsersInstance.rank}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'rankDelta', 'error')} required">
	<label for="rankDelta">
		<g:message code="FUsers.rankDelta.label" default="Rank Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rankDelta" type="number" value="${FUsersInstance.rankDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'rankTeam', 'error')} required">
	<label for="rankTeam">
		<g:message code="FUsers.rankTeam.label" default="Rank Team" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rankTeam" type="number" value="${FUsersInstance.rankTeam}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'rankTeamDelta', 'error')} required">
	<label for="rankTeamDelta">
		<g:message code="FUsers.rankTeamDelta.label" default="Rank Team Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="rankTeamDelta" type="number" value="${FUsersInstance.rankTeamDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'teamId', 'error')} required">
	<label for="teamId">
		<g:message code="FUsers.teamId.label" default="Team Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="teamId" type="number" value="${FUsersInstance.teamId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'timestamp', 'error')} required">
	<label for="timestamp">
		<g:message code="FUsers.timestamp.label" default="Timestamp" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="timestamp" type="number" value="${FUsersInstance.timestamp}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'wuDelta', 'error')} required">
	<label for="wuDelta">
		<g:message code="FUsers.wuDelta.label" default="Wu Delta" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wuDelta" type="number" value="${FUsersInstance.wuDelta}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: FUsersInstance, field: 'wuTotal', 'error')} required">
	<label for="wuTotal">
		<g:message code="FUsers.wuTotal.label" default="Wu Total" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="wuTotal" type="number" value="${FUsersInstance.wuTotal}" required=""/>
</div>

