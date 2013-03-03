package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserFixtures
import com.mb.stats.features.verify.VerifyCorsHeader
import com.mb.stats.features.verify.VerifyExpiresHeader
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON
import spock.lang.Unroll

@Mixin([UserFixtures, VerifyExpiresHeader, VerifyCorsHeader])
class ListUsersForTeamSpec extends RemoteServiceGebSpec {

    def "list for team"() {

        given:
        def fixtures = setupFixturesFor usersForTeamList(62, 10)

        when:
        RestResponse r = jsonClient.get('v1/teams/62/users')
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j.total == 10
        j.results == fixtures
    }

    def "list for team with other teams"() {

        given:
        def fixtures = setupFixturesFor usersForTeamList(62, 10).plus(usersForTeamList(30, 10))

        when:
        RestResponse r = jsonClient.get('v1/teams/62/users')
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        j.total == 10
        j.results == fixtures.findAll { it.teamId == 62 }
    }

    @Unroll
    def "list sort by #sort #order"() {

        given:
        def fixtures = setupFixturesFor usersForTeamList(62, 10)

        and:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        when:
        RestResponse r = jsonClient.get("v1/teams/62/users?sort=$sort&order=$order")
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j.total == 10
        j.results == fixtures[0..9]

        where:
        sort        | order
        "ptsTotal"  | "desc"
        "ptsDelta"  | "desc"
        "wuTotal"   | "desc"
        "wuDelta"   | "desc"
        "rank"      | "desc"
        "rankDelta" | "desc"
        "ptsDay"    | "desc"
        "ptsWeek"   | "desc"
        "garbage"   | "desc"
        "ptsDay"    | "garbage"
        "ptsTotal"  | "asc"
        "ptsDelta"  | "asc"
        "wuTotal"   | "asc"
        "wuDelta"   | "asc"
        "rank"      | "asc"
        "rankDelta" | "asc"
        "ptsDay"    | "asc"
        "ptsWeek"   | "asc"
        "garbage"   | "asc"
        "ptsweek"   | "asc"

    }

    @Unroll
    def "list illegal offset #offset and limit #limit"() {

        given:
        def fixtures = setupFixturesFor usersForTeamList(62, 1010)

        when:
        RestResponse r = jsonClient.get("v1/teams/62/users?limit=$limit&offset=$offset")
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j.total == 1010
        j.results == fixtures[expectedOffset..(expectedLimit - 1)]

        where:
        offset | expectedOffset | limit | expectedLimit
        -100   | 0              | -1    | 1
        -1     | 0              | -100  | 1
        0      | 0              | 10000 | 1000
        0      | 0              | 1001  | 1000
    }

    @Unroll
    def "list offset #offset and limit #limit"() {

        given:
        def fixtures = setupFixturesFor usersForTeamList(62, 100)

        when:
        RestResponse r = jsonClient.get("v1/teams/62/users?limit=$limit&offset=$offset")
        def j = JSON.parse r.bodyAsString

        then:
        verifyCacheExpireByNextUpdate(r)
        verifyCorsHeader(r)
        j.total == 100
        j.results == fixtures[offset..offset + (limit - 1)]

        where:
        offset | limit
        0      | 50
        1      | 50
        10     | 50
        50     | 50
        0      | 100
        0      | 10
        0      | 9
        1      | 9
        9      | 9
        50     | 10
    }
}
