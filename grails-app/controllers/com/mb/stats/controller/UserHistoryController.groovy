package com.mb.stats.controller

import com.mb.stats.RequestUserHistoryTimestampBetweenCommand
import com.mb.stats.UserHistoryService
import grails.converters.JSON

class UserHistoryController {

    UserHistoryService userHistoryService

    def listBetween(RequestUserHistoryTimestampBetweenCommand r) {

        render asUsersList(userHistoryService.listBetween(r))
    }

    private def asUsersList(def list) {

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
                            rankTeam: it.rankTeam,
                            rankTeamDelta: it.rankTeamDelta,
                            ptsDay: it.ptsDay,
                            ptsWeek: it.ptsWeek,
                            timestamp: it.timestamp
                    ]

                }
        ] as JSON
    }
}
