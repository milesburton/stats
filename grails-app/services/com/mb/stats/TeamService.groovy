package com.mb.stats

import com.mb.stats.domain.Team

class TeamService {

    def list(Map params) {
        Team.list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true)
    }

    def search(String q, Map params) {
        Team.createCriteria().list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true) {
            like('alias', "$q%")
        }
    }
}
