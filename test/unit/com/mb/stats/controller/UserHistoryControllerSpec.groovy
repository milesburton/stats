package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.RequestUserHistoryTimestampBetweenCommand
import com.mb.stats.UserHistoryService
import com.mb.stats.controller.helper.MockCacheCall
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UserHistoryController)
class UserHistoryControllerSpec extends Specification {

    PagedResultList fakeResult
    MockCacheCall mockCache = new MockCacheCall()

    def setup() {
        controller.userHistoryService = Mock(UserHistoryService)

        fakeResult = new FakePagedResultList()
        controller.cachableTillNextUpdateService = Mock(CachableTillNextUpdateService)

        mockCache.mockCacheCall(controller)
    }

    def 'list between'() {

        given:
        RequestUserHistoryTimestampBetweenCommand r = new RequestUserHistoryTimestampBetweenCommand(alias: 'TeamMCS', teamId: 62, timestampBegin: 0, timestampEnd: 1)

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
        1 * controller.userHistoryService.listBetween(r) >> fakeResult
        0 * _._
    }

}
