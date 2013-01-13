package com.mb.domain

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import spock.lang.Specification
import spock.lang.Unroll

import java.lang.reflect.Type

import grails.test.mixin.*

@Mock(Team)
@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    List<Team> fixtures

    def setup() {
        fixtures = createFixtureList()
    }

    def "list"() {

        when:
        controller.index()

        then:
        toTeams(response.contentAsString) == fixtures[0..49]
    }

    @Unroll
    def "list sort by #sort #order"() {

        given:
        params.sort = sort
        params.order = order

        and:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        when:
        controller.index()

        then:
        toTeams(response.contentAsString) == fixtures[0..49]

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
        fixtures = createFixtureList(2000)

        and:
        params.offset = offset
        params.limit = limit

        when:
        controller.index()

        then:
        toTeams(response.contentAsString) == fixtures[expectedOffset..(expectedLimit - 1)]

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
        params.offset = offset
        params.limit = limit

        when:
        controller.index()

        then:
        toTeams(response.contentAsString) == fixtures[offset..offset + (limit - 1)]

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

    def toTeams(String j) {

        Type listType = new TypeToken<ArrayList<Team>>() {
        }.getType();

        new Gson().fromJson(j, listType)
    }


    def createFixtureList(int count = 100) {

        def fixtures = []

        for (int i = 0; i < count; i++) {
            fixtures.add new Team(
                    teamId: i,
                    alias: "team " + Character.toChars(Math.abs(new Random().nextInt() % 26) + 65) + " $i ",
                    ptsTotal: i,
                    ptsDelta: i,
                    wuTotal: i,
                    wuDelta: i,
                    rank: i,
                    rankDelta: i,
                    ptsDay: i,
                    ptsWeek: i,
            )

        }

        fixtures.sort { it.ptsTotal }
        fixtures.reverse(true)
        fixtures*.save(flush: true)

        fixtures
    }
}
