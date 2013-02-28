package com.mb.stats.controller

import com.mb.stats.RequestTeamHistoryTimestampBetweenCommand
import com.mb.stats.TeamHistoryService
import grails.converters.JSON

class TeamHistoryController {

    TeamHistoryService teamHistoryService

    def listBetween(RequestTeamHistoryTimestampBetweenCommand r) {

        cache: "tillNextUpdate"
        render asList(teamHistoryService.listBetween(r))
    }

    private def asList(def list) {

        [
                total: list.totalCount,
                results: list.collect {
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
        ] as JSON
    }
}
