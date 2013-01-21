package com.mb.stats

import com.mb.stats.domain.UserHistory

class UserHistoryService {

    def listBetween(RequestUserHistoryTimestampBetweenCommand r) {

        UserHistory.createCriteria().list(sort: 'timestamp',order: 'desc', cache: true) {
            between("timestamp", r.timestampBegin, r.timestampEnd)
            and {
                eq("alias", r.alias)
                eq("teamId", r.teamId)
            }

        }
    }
}
