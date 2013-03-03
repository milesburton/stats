package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.ListParamSanitizerService
import com.mb.stats.UserService
import com.mb.stats.controller.helper.MockCacheCall
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UsersController)
class UserControllerSpec extends Specification {

    PagedResultList fakeResult
    MockCacheCall mockCache = new MockCacheCall()

    def setup() {
        controller.userService = Mock(UserService)
        controller.listParamSanitizerService = Mock(ListParamSanitizerService)
        controller.cachableTillNextUpdateService = Mock(CachableTillNextUpdateService)

        fakeResult = new FakePagedResultList()
        mockCache.mockCacheCall(controller)
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
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.search(q, params) >> fakeResult
        0 * _._
    }

    def 'search within team'() {

        given:
        Map params = [:]
        String q = "search"
        int teamId = 62

        when:
        controller.searchWithinTeam(teamId, q)

        then:
        response.json == [
                total: 0,
                results: []
        ]

        and:
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.searchWithinTeam(teamId, q, params) >> fakeResult
        0 * _._
    }

    def 'list'() {

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
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
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
        mockCache.verifyCacheCalled(controller)
        1 * controller.cachableTillNextUpdateService.tillNextUpdate() >> [:]
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.userService.listForTeam(teamId, params) >> fakeResult
        0 * _._
    }
}
