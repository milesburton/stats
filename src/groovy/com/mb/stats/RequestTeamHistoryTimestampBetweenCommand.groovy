package com.mb.stats

import grails.validation.Validateable
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
@Validateable
class RequestTeamHistoryTimestampBetweenCommand {

    Long teamId
    Long timestampBegin
    Long timestampEnd

    static constraints = {
        timestampBegin blank: false
        timestampEnd blank: false
        teamId blank: false
    }
}
