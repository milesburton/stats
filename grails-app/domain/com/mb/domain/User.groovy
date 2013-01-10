package com.mb.domain

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

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
        table 'sers'
        id composite: ['alias', 'teamId']
    }

	static constraints = {
		alias maxSize: 199
	}
}
