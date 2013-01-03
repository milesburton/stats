package com.mb.domain

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class FUsers implements Serializable {

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

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append teamId
		builder.append alias
		builder.append ptsTotal
		builder.append ptsDelta
		builder.append wuTotal
		builder.append wuDelta
		builder.append rank
		builder.append rankDelta
		builder.append timestamp
		builder.append rankTeam
		builder.append rankTeamDelta
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append teamId, other.teamId
		builder.append alias, other.alias
		builder.append ptsTotal, other.ptsTotal
		builder.append ptsDelta, other.ptsDelta
		builder.append wuTotal, other.wuTotal
		builder.append wuDelta, other.wuDelta
		builder.append rank, other.rank
		builder.append rankDelta, other.rankDelta
		builder.append timestamp, other.timestamp
		builder.append rankTeam, other.rankTeam
		builder.append rankTeamDelta, other.rankTeamDelta
		builder.isEquals()
	}

	static mapping = {
		id composite: ["teamId", "alias", "ptsTotal", "ptsDelta", "wuTotal", "wuDelta", "rank", "rankDelta", "timestamp", "rankTeam", "rankTeamDelta"]
		version false
	}

	static constraints = {
		alias maxSize: 199
	}
}
