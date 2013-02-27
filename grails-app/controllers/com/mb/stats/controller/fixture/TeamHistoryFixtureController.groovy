package com.mb.stats.controller.fixture

import com.mb.stats.domain.Team
import com.mb.stats.domain.TeamHistory
import com.mb.stats.domain.UserHistory
import grails.converters.JSON

class TeamHistoryFixtureController {

    def create() {

        render createFixtureList(params.count.toInteger()) as JSON
    }

    private def createFixtureList(int count = 100) {

        def fixtures = []

        for (int i = 0; i < count; i++) {
            fixtures.add new TeamHistory(
                    teamId: 62,
                    alias: "team",
                    ptsTotal: i,
                    ptsDelta: i,
                    wuTotal: i,
                    wuDelta: i,
                    rank: i,
                    rankDelta: i,
                    ptsDay: i,
                    ptsWeek: i,
                    timestamp: i            )

        }

        deleteAll()

        sort(fixtures)
        fixtures*.save(flush:true)

        asResults fixtures
    }

    private void sort(ArrayList fixtures) {
        fixtures.sort { it.timestamp }
        fixtures.reverse(true)
    }

    private void deleteAll() {
        TeamHistory.executeUpdate("DELETE TeamHistory")
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
                    ptsDay: it.ptsDay,
                    ptsWeek: it.ptsWeek,
                    timestamp: it.timestamp
            ]

        }
    }
}
