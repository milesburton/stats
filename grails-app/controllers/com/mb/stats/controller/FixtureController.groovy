package com.mb.stats.controller

import com.mb.stats.domain.Team
import grails.converters.JSON

class FixtureController {

    def teams() {

        render createFixtureList(params.count.toInteger()) as JSON
    }

    private def createFixtureList(int count = 100) {

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

        Team.executeUpdate("DELETE Team")

        fixtures.sort { it.ptsTotal }
        fixtures.reverse(true)
        fixtures*.save(flush:true)

        asResults fixtures
    }

    private List asResults(def list){

        list.collect {
            [
                    teamId: it.teamId,
                    alias: it.alias,
                    ptsTotal: it.ptsTotal,
                    ptsDelta: it.ptsDelta,
                    wuTotal: it.wuTotal,
                    rank: it.rank,
                    rankDelta: it.rankDelta,
                    ptsDay: it.ptsDay,
                    ptsWeek: it.ptsWeek
            ]

        }
    }
}
