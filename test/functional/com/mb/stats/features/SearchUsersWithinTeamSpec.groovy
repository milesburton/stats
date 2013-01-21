package com.mb.stats.features

import com.mb.stats.domain.User
import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserFixtures
import com.mb.stats.features.fixture.UserHistoryFixtures
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON
import spock.lang.Unroll

@Mixin(UserFixtures)
class SearchUsersWithinTeamSpec extends RemoteServiceGebSpec {

    def "search within team"() {

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
                        ,
                        new User(
                                teamId: 2,
                                alias: "Test 2",
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
                ]
        )

        and:
        String q = "Test"

        when:
        RestResponse r = jsonClient.get("v1/teams/1/users/search/$q")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 1
        j.results == fixtures[1..1]
    }

    @Unroll
    def "search within team sort by #sort #order"() {

        given:
        def fixtures = customTeamFixturesForTeam(1, 5)

        and:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        and:
        String q = "user"

        when:
        RestResponse r = jsonClient.get("v1/teams/1/users/search/$q?sort=$sort&order=$order")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 5
        j.results == fixtures

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
    def "search within team illegal offset #offset and limit #limit"() {

        given:
        def fixtures = customTeamFixturesForTeam(1, 1010)

        and:
        String q = "user"

        when:

        RestResponse r = jsonClient.get("v1/teams/1/users/search/$q?limit=$limit&offset=$offset")

        then:
        def j = JSON.parse r.bodyAsString
        def expectedResults = fixtures[expectedOffset..(expectedLimit - 1)]
        j == [total: 1010, results: expectedResults]


        where:
        offset | expectedOffset | limit | expectedLimit
        -100   | 0              | -1    | 1
        -1     | 0              | -100  | 1
        0      | 0              | 10000 | 1000
        0      | 0              | 1001  | 1000
    }

    @Unroll
    def "search within team offset #offset and limit #limit"() {

        given:
        def fixtures = customTeamFixturesForTeam(1, 100)

        and:
        String q = "user"

        when:
        RestResponse r = jsonClient.get("v1/teams/1/users/search/$q?limit=$limit&offset=$offset")

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
