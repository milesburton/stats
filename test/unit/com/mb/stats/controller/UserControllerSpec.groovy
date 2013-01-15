package com.mb.stats.controller

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.TeamService
import com.mb.stats.UserService
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UsersController)
class UserControllerSpec extends Specification {

    PagedResultList fakeResult

    def setup() {
        controller.userService = Mock(UserService)
        controller.listParamSanitizerService = Mock(ListParamSanitizerService)

        fakeResult = new FakePagedResultList()

        config.stats.users = [:]
    }

    def 'search'() {

        given:
        Map params = [:]
        String q = "search"
        int teamId = 62

        when:
        controller.search(teamId, q)

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.search(teamId, q, params) >> fakeResult
        0 * _._
    }

    def 'index'() {

        given:
        Map params = [:]

        when:
        controller.index()

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.teamService.list(params) >> fakeResult
        0 * _._
    }
}
