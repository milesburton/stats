package com.mb.stats

import com.mb.stats.domain.Team
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TeamService)
class TeamServiceSpec extends Specification {

    def 'list'() {

        given:
        Map params = [offset: 0, limit: 0, sort: "sort", order: "order"]
        List fakeResults = []

        and:
        def mockTeam = mockFor(Team)

        mockTeam.demand.static.list(1) { Map args ->
            if (args != [offset: 0, max: 0, sort: "sort", order: "order", cache: true]) throw new Exception("Failed test")
            fakeResults
        }

        expect:
        service.list(params) == fakeResults
        mockTeam.verify() == null
    }

    def 'search'() {

        given:
        Map params = [offset: 0, limit: 0, sort: "sort", order: "order"]
        String q = "query"
        List fakeResults = []

        and:
        def mockTeam = mockFor(Team)

        mockTeam.demand.static.findAllByAliasLike(1) { String term, Map args ->
            if (args != [offset: 0, max: 0, sort: "sort", order: "order", cache: true] &&
                    term == q
            ) throw new Exception("Failed test")
            fakeResults
        }

        expect:
        service.search(q, params) == fakeResults
        mockTeam.verify() == null
    }

}
