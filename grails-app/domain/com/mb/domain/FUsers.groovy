package com.mb.domain

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class FUsers implements  Serializable {

	Long teamId
	String alias
	Long ptsTotal
	Long ptsDelta
	Long wuTotal
	Long wuDelta
	Long rank
	Long rankDelta
	Long timestamp
	Long rankTeam
	Long rankTeamDelta

    static mapping = {
        version false
        table 'f_users'
        id composite: ['alias', 'teamId']
    }

	static constraints = {
		alias maxSize: 199
	}
}
