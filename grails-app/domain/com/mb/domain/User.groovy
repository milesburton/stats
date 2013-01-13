package com.mb.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

@ToString
@EqualsAndHashCode
class User implements  Serializable {

	Long teamId
	String alias
	Long ptsTotal
	Long ptsDelta
	Long wuTotal
	Long wuDelta
	Long rank
	Long rankDelta
	Long rankTeam
	Long rankTeamDelta
    Long ptsDay
    Long ptsWeek

    static mapping = {
        version false
        table 'users'
        id composite: ['alias', 'teamId']
    }

	static constraints = {
		alias maxSize: 199
	}
}
