package com.mb.stats.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class TeamHistory implements Serializable {

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
    Long timestamp

    static mapping = {
        version false
        table 'f_teams'
        id composite: ['teamId', 'timestamp']
        cache true

    }
}
