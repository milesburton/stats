package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserHistoryFixtures
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON

@Mixin(UserHistoryFixtures)
class ListUserHistorySpec extends RemoteServiceGebSpec {

    def "list between"() {

        given:
        def fixtures = userHistoryFixtures(3)

        when:
        RestResponse r = jsonClient.get('teams/62/users/user/history?timestampBegin=0&timestampEnd=101')

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 3
        j.results == fixtures
    }
}
