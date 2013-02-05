package com.mb.stats

import com.mb.stats.domain.User

class UserService {

    def list(Map params) {

        User.list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true)
    }

    def listForTeam(Long teamId, Map params) {

        User.createCriteria().list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true) {
            eq('teamId', teamId)
        }
    }

    def search(String q, Map params) {

        User.createCriteria().list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true) {
            like('alias', "$q%")
        }
    }

    def searchWithinTeam(Long teamId, String q, Map params) {

        User.createCriteria().list(offset: params.offset, max: params.limit, sort: params.sort, order: params.order, cache: true) {
            like('alias', "$q%")
            and {
                eq('teamId', teamId)
            }
        }
    }
}
