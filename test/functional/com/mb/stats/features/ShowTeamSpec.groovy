package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.TeamFixtures
import com.mb.stats.features.verify.VerifyCorsHeader
import com.mb.stats.features.verify.VerifyExpiresHeader
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON

@Mixin([TeamFixtures, VerifyExpiresHeader, VerifyCorsHeader])
class ShowTeamSpec extends RemoteServiceGebSpec {

    def "list"() {

        given:
        def fixtures = teamFixtures(1)

        when:
        RestResponse r = jsonClient.get('v1/teams/0')
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j == fixtures[0]
    }

}
