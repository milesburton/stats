package com.mb.stats.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class User implements Serializable {

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
        table 'ag_users'
        id composite: ['alias', 'teamId']
        cache true
    }

    static constraints = {
        alias maxSize: 199
    }
}
