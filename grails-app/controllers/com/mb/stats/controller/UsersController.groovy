package com.mb.stats.controller

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.UserService
import com.mb.stats.domain.User
import grails.converters.JSON

class UsersController {

    UserService userService
    ListParamSanitizerService listParamSanitizerService

    def list() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        render asUsersList(userService.list(params))
    }

    def listForTeam(int teamId) {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        render asUsersList(userService.listForTeam(teamId, params))
    }

    def search(String q) {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        render asUsersList(userService.search(q, params))
    }

    private Map getConfig() {
        grailsApplication.config.stats.users
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
                            rank: it.rank,
                            rankDelta: it.rankDelta,
                            ptsDay: it.ptsDay,
                            ptsWeek: it.ptsWeek
                    ]

                }
        ] as JSON
    }
}
