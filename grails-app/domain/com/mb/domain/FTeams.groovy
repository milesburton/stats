package com.mb.domain

class FTeams implements  Serializable{

	Long teamId
	String alias
	Long ptsTotal
	Long ptsDelta
	Long wuTotal
	Long wuDelta
	Long rank
	Long rankDelta
	Long timestamp
    Long ptsDay
    Long ptsWeek

    static mapping = {
        version false
        table 'f_teams'
        id name: 'teamId' , generator: 'assigned'


    }

	static constraints = {
		alias maxSize: 199
		timestamp nullable: true
	}
}
