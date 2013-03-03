package com.mb.stats.controller.fixture

import com.mb.stats.domain.Team
import com.mb.stats.domain.User
import grails.converters.JSON

class UsersFixtureController {

    def create() {

        render createFixtureList(params.count.toInteger()) as JSON
    }

    def custom() {

        deleteAllUsers()

        def fixtures = request.JSON.collect { new User(it) }
        sort(fixtures)
        fixtures*.save(flush: true)

        render asResults(fixtures) as JSON
    }

    private def createFixtureList(int count = 100) {

        def fixtures = []

        for (int i = 0; i < count; i++) {
            fixtures.add new User(
                    teamId: i,
                    alias: "user " + Character.toChars(Math.abs(new Random().nextInt() % 26) + 65) + " $i ",
                    ptsTotal: i,
                    ptsDelta: i,
                    wuTotal: i,
                    wuDelta: i,
                    rank: i,
                    rankDelta: i,
                    ptsDay: i,
                    ptsWeek: i,
                    rankTeam: i,
                    rankTeamDelta: i
            )

        }

        deleteAllUsers()

        sort(fixtures)
        fixtures*.save(flush: true)

        asResults fixtures
    }

    private void sort(ArrayList fixtures) {
        fixtures.sort { it.ptsTotal }
        fixtures.reverse(true)
    }

    private void deleteAllUsers() {
        Team.executeUpdate("DELETE User")
    }

    private List asResults(def list) {

        list.collect {
            [
                    teamId: it.teamId,
                    alias: it.alias,
                    ptsTotal: it.ptsTotal,
                    ptsDelta: it.ptsDelta,
                    wuTotal: it.wuTotal,
                    wuDelta: it.wuDelta,
                    rank: it.rank,
                    rankDelta: it.rankDelta,
                    rankTeam: it.rankTeam,
                    rankTeamDelta: it.rankTeamDelta,
                    ptsDay: it.ptsDay,
                    ptsWeek: it.ptsWeek,

            ]

        }
    }
}
