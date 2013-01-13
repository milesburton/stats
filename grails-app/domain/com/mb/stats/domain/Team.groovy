package com.mb.stats.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Team implements  Serializable{

	Long teamId
	String alias
	Long ptsTotal
	Long ptsDelta
	Long wuTotal
	Long wuDelta
	Long rank
	Long rankDelta
    Long ptsDay
    Long ptsWeek

    static mapping = {
        version false
        table 'teams'
        id name: 'teamId' , generator: 'assigned'
        cache true

    }
}
