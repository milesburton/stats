package com.mb.domain

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import spock.lang.Specification

import java.lang.reflect.Type

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*


@TestFor(TeamsController)
class TeamsControllerSpec extends Specification {

    def "return top ten users ordered by points"() {

        given:
        def fixtures = createFixtureList()
        fixtures*.save(flush: true)

        when:
        controller.index()

        then:
        List<Team> response = convertJsonToListOfTeams(controller.response.contentAsString)


    }

    def convertJsonToListOfTeams(String j) {

        Type listType = new TypeToken<ArrayList<Team>>() {
        }.getType();

        new Gson().fromJson(j, listType)
    }


    def createFixtureList(int count = 10) {

        def fixtures = []

        for (int i = 0; i < count; i++) {
            fixtures << new Team(
                    teamId: i,
                    alias: "team $i",
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

        fixtures
    }
}
