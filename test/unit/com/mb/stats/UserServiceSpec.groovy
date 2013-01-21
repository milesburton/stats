package com.mb.stats

import com.mb.stats.domain.User
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(UserService)
class UserServiceSpec extends Specification {

    def 'list'() {

        given:
        Map params = [offset: 0, limit: 0, sort: "sort", order: "order"]
        List fakeResults = []

        and:
        def mockUser = mockFor(User)

        mockUser.demand.static.list(1) { Map args ->
            if (args != [offset: 0, max: 0, sort: "sort", order: "order", cache: true]) throw new Exception("Failed test")
            fakeResults
        }

        expect:
        service.list(params) == fakeResults
        mockUser.verify() == null
    }

    def 'list for team'() {

        given:
        Map params = [offset: 0, limit: 0, sort: "sort", order: "order"]
        int teamId = 62
        List fakeResults = []

        and:
        def mockUser = mockFor(User)

        mockUser.demand.static.list(1) { Map args ->
            if (args != [teamId: teamId, offset: 0, max: 0, sort: "sort", order: "order", cache: true]) throw new Exception("Failed test")
            fakeResults
        }

        expect:
        service.listForTeam(teamId, params) == fakeResults
        mockUser.verify() == null
    }

}
