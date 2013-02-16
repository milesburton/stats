package com.mb.stats.controller

import com.mb.stats.ListParamSanitizerService

import com.mb.stats.TeamService
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    PagedResultList fakeResult

    def setup() {
        controller.teamService = Mock(TeamService)
        controller.listParamSanitizerService = Mock(ListParamSanitizerService)

        fakeResult = new FakePagedResultList()

        config.stats.teams = [:]
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
        1 * controller.teamService.search(q, params) >> fakeResult
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
        1 * controller.listParamSanitizerService.sanitizePaginationParams(params, [:])
        1 * controller.teamService.list(params) >> fakeResult
        0 * _._
    }
}
