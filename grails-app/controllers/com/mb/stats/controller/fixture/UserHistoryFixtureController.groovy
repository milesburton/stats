package com.mb.stats.controller.fixture

import com.mb.stats.domain.Team
import com.mb.stats.domain.User
import com.mb.stats.domain.UserHistory
import grails.converters.JSON

class UserHistoryFixtureController {

    def create() {

        render createFixtureList(params.count.toInteger()) as JSON
    }

    def custom(){

        deleteAllUsers()

        def fixtures = request.JSON.collect { new UserHistory(it) }
        sort(fixtures)
        fixtures*.save(flush:true)

        render asResults(fixtures) as JSON
    }

    private def createFixtureList(int count = 100) {

        def fixtures = []

        for (int i = 0; i < count; i++) {
            fixtures.add new UserHistory(
                    teamId: 62,
                    alias: "user",
                    ptsTotal: i,
                    ptsDelta: i,
                    wuTotal: i,
                    wuDelta: i,
                    rank: i,
                    rankDelta: i,
                    ptsDay: i,
                    ptsWeek: i,
                    rankTeam: i,
                    rankTeamDelta: i,
                    timestamp: i

            )

        }

        deleteAllUsers()

        sort(fixtures)
        fixtures*.save(flush:true)

        asResults fixtures
    }

    private void sort(ArrayList fixtures) {
        fixtures.sort { it.timestamp }
        fixtures.reverse(true)
    }

    private void deleteAllUsers() {
        Team.executeUpdate("DELETE UserHistory")
    }

    private List asResults(def list){

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
                    timestamp: it.timestamp
            ]

        }
    }
}
