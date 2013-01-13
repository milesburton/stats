package com.mb.stats.controller

import com.mb.stats.TeamParamSanitizerService
import com.mb.stats.TeamService
import grails.gorm.PagedResultList
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    PagedResultList fakeResult = new FakePagedResultList()

    def setup() {
        controller.teamService = Mock(TeamService)
        controller.teamParamSanitizerService = Mock(TeamParamSanitizerService)
    }

    def 'index'(){

        given:
        Map params = [:]

        when:
        controller.index()

        then:
        response.json.total == 0
        response.json.results.total == []

        and:
        1 * controller.teamParamSanitizerService.sanitizePaginationParams(params)
        1 * controller.teamService.list(params) >> fakeResult
        0 * _._
    }

    def 'search'(){

        given:
        Map params = [:]
        String q = "search"

        when:
        controller.search(q)

        then:
        response.json.total == 0
        response.json.results.total == []

        and:
        1 * controller.teamParamSanitizerService.sanitizePaginationParams(params)
        1 * controller.teamService.search(q, params) >> fakeResult
        0 * _._
    }
}
