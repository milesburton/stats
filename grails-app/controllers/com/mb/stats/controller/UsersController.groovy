package com.mb.stats.controller

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.UserService
import com.mb.stats.domain.User
import grails.converters.JSON

class UsersController {

    UserService userService
    ListParamSanitizerService listParamSanitizerService

    def index() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        render asTeamsList(userService.list(params))
    }

    def search(int teamId, String q) {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        render asTeamsList(userService.search(teamId, q, params))
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
