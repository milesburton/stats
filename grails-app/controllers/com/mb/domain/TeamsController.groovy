package com.mb.domain

import grails.converters.JSON

class TeamsController {

    def index() {

        int offset = Math.max(params.offset ?: 0, 0)
        int limit = Math.min(Math.max(params.limit ?: 50, 1), 1000)
        String sort = params.sort ?: "ptsTotal"
        sort = Team.hasProperty(sort) ? sort : "ptsTotal"
        String order = ["desc","asc"].contains(params.order) ? params.order : "desc"

        List<Team> r = Team.list(offset: offset, max: limit, sort: sort, order: order)

        render r as JSON

    }
}
