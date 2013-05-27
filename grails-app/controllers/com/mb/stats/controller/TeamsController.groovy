package com.mb.stats.controller

import com.mb.stats.CachableTillNextUpdateService
import com.mb.stats.ListParamSanitizerService
import com.mb.stats.TeamService
import com.mb.stats.domain.Team
import grails.converters.JSON

class TeamsController {

    CachableTillNextUpdateService cachableTillNextUpdateService
    ListParamSanitizerService listParamSanitizerService
    TeamService teamService

    def list() {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()
        render asTeamsList(teamService.list(params)) as JSON
    }

    def show(Long teamId) {

        cache cachableTillNextUpdateService.tillNextUpdate()

        def team = teamService.get(teamId)

        if (team) {
            render asTeam(team) as JSON
        } else {
            render status: 404
        }
    }

    def search(String q) {

        listParamSanitizerService.sanitizePaginationParams(params, config)

        cache cachableTillNextUpdateService.tillNextUpdate()
        render asTeamsList(teamService.search(q, params)) as JSON
    }

    private Map getConfig() {
        grailsApplication.config.stats.teams
    }

    private def asTeamsList(def list) {

        [
                total: list.totalCount,
                results: list.collect {
                    asTeam(it)
                }
        ]
    }

    private Map asTeam(Team team) {
        [
                teamId: team.teamId,
                alias: team.alias,
                ptsTotal: team.ptsTotal,
                ptsDelta: team.ptsDelta,
                wuTotal: team.wuTotal,
                rank: team.rank,
                rankDelta: team.rankDelta,
                ptsDay: team.ptsDay,
                ptsWeek: team.ptsWeek
        ]
    }

}
