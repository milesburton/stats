package com.mb.stats.controller

import com.mb.stats.RequestTeamHistoryTimestampBetweenCommand
import com.mb.stats.TeamHistoryService
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamHistoryController)
class TeamHistoryControllerSpec extends Specification {

    PagedResultList fakeResult

    def setup() {
        controller.teamHistoryService = Mock(TeamHistoryService)

        fakeResult = new FakePagedResultList()
    }

    def 'list between'() {

        given:
        RequestTeamHistoryTimestampBetweenCommand r = new RequestTeamHistoryTimestampBetweenCommand(teamId: 62, timestampBegin: 0, timestampEnd: 1)

        when:
        controller.listBetween(r)

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.teamHistoryService.listBetween(r) >> fakeResult
        0 * _._
    }

}
