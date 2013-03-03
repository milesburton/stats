package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.TeamHistoryFixtures
import com.mb.stats.features.verify.VerifyCorsHeader
import com.mb.stats.features.verify.VerifyExpiresHeader
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON

@Mixin([TeamHistoryFixtures, VerifyExpiresHeader, VerifyCorsHeader])
class ListTeamHistorySpec extends RemoteServiceGebSpec {

    def "list between"() {

        given:
        def fixtures = teamHistoryFixtures(3)

        when:
        RestResponse r = jsonClient.get('v1/teams/62/history?timestampBegin=0&timestampEnd=101')
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j.total == 3
        j.results == fixtures
    }
}
