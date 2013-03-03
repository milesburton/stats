package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.ListParamSanitizerService
import com.mb.stats.TeamService
import grails.converters.JSON

class TeamsController {

    CachableTillNextUpdateService cachableTillNextUpdateService
    ListParamSanitizerService listParamSanitizerService
    TeamService teamService

    def list() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()
        render asTeamsList(teamService.list(params))
    }

    def search(String q) {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()
        render asTeamsList(teamService.search(q, params))
    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }

    private def asTeamsList(def list) {

        [
                total: list.totalCount,
                results: list.collect {
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
        ] as JSON
    }

}
