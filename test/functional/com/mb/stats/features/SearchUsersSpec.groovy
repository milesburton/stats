package com.mb.stats.features

import com.mb.stats.domain.User
import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserFixtures
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON
import spock.lang.Unroll

@Mixin(UserFixtures)
class SearchUsersSpec extends RemoteServiceGebSpec {

    def "search"() {

        given:
        def fixtures = customTeamFixtures(
                [
                        new User(
                                teamId: 1,
                                alias: "Test",
                                ptsTotal: 1,
                                ptsDelta: 1,
                                wuTotal: 1,
                                wuDelta: 1,
                                rank: 1,
                                rankDelta: 1,
                                ptsDay: 1,
                                ptsWeek: 1,
                                rankTeam: 1,
                                rankTeamDelta: 1)
                ])

        and:
        String q = "Test"

        when:
        RestResponse r = jsonClient.get("users/search/$q")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 1
        j.results == fixtures
    }

    @Unroll
    def "search sort by #sort #order"() {

        given:
        def fixtures = userFixtures(5)

        and:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        and:
        String q = "user"

        when:
        RestResponse r = jsonClient.get("users/search/$q?sort=$sort&order=$order")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 5
        j.results == fixtures[0..4]

        where:
        sort        | order
        "teamId"    | "desc"
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
        "teamId"    | "asc"
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
    def "search illegal offset #offset and limit #limit"() {

        given:
        def fixtures = userFixtures(1010)

        and:
        String q = "user"

        when:
        RestResponse r = jsonClient.get("users/search/$q?limit=$limit&offset=$offset")

        then:
        def j = JSON.parse r.bodyAsString
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
    def "search offset #offset and limit #limit"() {

        given:
        def fixtures = userFixtures(100)

        and:
        String q = "user"

        when:
        RestResponse r = jsonClient.get("users/search/$q?limit=$limit&offset=$offset")

        then:
        def j = JSON.parse r.bodyAsString
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
