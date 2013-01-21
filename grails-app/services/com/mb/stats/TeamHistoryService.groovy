package com.mb.stats

import com.mb.stats.domain.TeamHistory

class TeamHistoryService {

    def listBetween(RequestTeamHistoryTimestampBetweenCommand r) {

        TeamHistory.createCriteria().list(sort: 'timestamp', order: 'desc', cache: true) {
            between("timestamp", r.timestampBegin, r.timestampEnd)
            and {
                eq("teamId", r.teamId)
            }

        }
    }
}
