package com.mb.stats.controller

import com.mb.stats.RequestUserHistoryTimestampBetweenCommand
import com.mb.stats.UserHistoryService
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UserHistoryController)
class UserHistoryControllerSpec extends Specification {

    PagedResultList fakeResult

    def setup() {
        controller.userHistoryService = Mock(UserHistoryService)

        fakeResult = new FakePagedResultList()
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
        1 * controller.userHistoryService.listBetween(r) >> fakeResult
        0 * _._
    }

}
