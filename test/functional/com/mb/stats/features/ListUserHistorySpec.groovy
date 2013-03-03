package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserHistoryFixtures
import com.mb.stats.features.verify.VerifyExpiresHeader
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON

@Mixin([UserHistoryFixtures, VerifyExpiresHeader])
class ListUserHistorySpec extends RemoteServiceGebSpec {

    def "list between"() {

        given:
        def fixtures = userHistoryFixtures(3)

        when:
        RestResponse r = jsonClient.get('v1/teams/62/users/user/history?timestampBegin=0&timestampEnd=101')
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        j.total == 3
        j.results == fixtures
    }
}
