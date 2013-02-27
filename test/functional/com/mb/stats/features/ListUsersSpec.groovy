package com.mb.stats.features

import com.mb.stats.features.base.RemoteServiceGebSpec
import com.mb.stats.features.fixture.UserFixtures
import com.mb.stats.features.fixture.UserHistoryFixtures
import com.popcornteam.restclient.response.RestResponse
import grails.converters.JSON
import spock.lang.Unroll

@Mixin(UserFixtures)
class ListUsersSpec extends RemoteServiceGebSpec {

    def "list"() {

        given:
        def fixtures = userFixtures(100)

        when:
        RestResponse r = jsonClient.get('v1/users')

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 100
        j.results == fixtures[0..49]
    }

    @Unroll
    def "list sort by #sort #order"() {

        given:
        def fixtures = userFixtures(100)

        and:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        when:
        RestResponse r = jsonClient.get("v1/users?sort=$sort&order=$order")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 100
        j.results == fixtures[0..49]

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
    def "list illegal offset #offset and limit #limit"() {

        given:
        def fixtures = userFixtures(1010)

        when:
        RestResponse r = jsonClient.get("v1/users?limit=$limit&offset=$offset")

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
    def "list offset #offset and limit #limit"() {

        given:
        def fixtures = userFixtures(100)

        when:
        RestResponse r = jsonClient.get("v1/users?limit=$limit&offset=$offset")

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
