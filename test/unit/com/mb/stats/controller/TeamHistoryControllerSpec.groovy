package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.RequestTeamHistoryTimestampBetweenCommand
import com.mb.stats.TeamHistoryService
import com.mb.stats.controller.helper.MockCacheCall
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamHistoryController)
class TeamHistoryControllerSpec extends Specification {

    PagedResultList fakeResult
    MockCacheCall mockCache = new MockCacheCall()

    def setup() {

        controller.teamHistoryService = Mock(TeamHistoryService)
        controller.cachableTillNextUpdateService = Mock(CachableTillNextUpdateService)

        fakeResult = new FakePagedResultList()

        mockCache.mockCacheCall(controller)
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
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.teamHistoryService.listBetween(r) >> fakeResult
        0 * _._
    }

}
