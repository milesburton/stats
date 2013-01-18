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

        when:
        controller.search(q)

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.search(q, params) >> fakeResult
        0 * _._
    }

    def 'index'() {

        given:
        Map params = [:]

        when:
        controller.list()

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.list(params) >> fakeResult
        0 * _._
    }

    def 'users in teams'() {

        given:
        Map params = [:]
        int teamId = 62

        when:
        controller.listForTeam(teamId)

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.listForTeam(teamId, params) >> fakeResult
        0 * _._
    }
}
