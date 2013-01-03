package com.mb.domain

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class FTeams implements Serializable {

	Long teamId
	String alias
	Long ptsTotal
	Long ptsDelta
	Long wuTotal
	Long wuDelta
	Long rank
	Long rankDelta
	Long timestamp



	static mapping = {

		version false
	}

	static constraints = {
		alias maxSize: 199
		timestamp nullable: true
	}
}
