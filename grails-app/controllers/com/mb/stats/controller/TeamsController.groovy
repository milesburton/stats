package com.mb.stats.controller

import com.mb.stats.TeamParamSanitizerService
import com.mb.stats.TeamService
import grails.converters.JSON

class TeamsController {

    TeamParamSanitizerService teamParamSanitizerService
    TeamService teamService

    def index() {

        teamParamSanitizerService.sanitizePaginationParams(params)

        renderList teamService.list(params)
    }

    def search(String q) {

        teamParamSanitizerService.sanitizePaginationParams(params)

        renderList teamService.search(q, params)
    }


    private void renderList(def list) {

        def j = [
                total: list.totalCount,
                results: asResults(list)
        ]
        render j as JSON
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
