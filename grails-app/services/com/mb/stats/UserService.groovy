package com.mb.stats

import com.mb.stats.domain.User

class UserService {
    def list(int teamId, Map params) {
        User.list(teamId: teamId, offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true)
    }

    def search(int teamId, String q, Map params) {
        User.createCriteria().list(teamId: teamId, offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true){
            like('alias', "$q%")
        }
    }
}
