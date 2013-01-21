package com.mb.stats.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class UserHistory implements  Serializable {

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
    Long timestamp

    static mapping = {
        version false
        table 'f_users'
        id composite: ['alias', 'teamId', 'timestamp']
        cache true
    }

	static constraints = {
		alias maxSize: 199
	}
}
