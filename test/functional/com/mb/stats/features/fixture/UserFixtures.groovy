package com.mb.stats.features.fixture

import com.mb.stats.domain.User
import com.popcornteam.restclient.request.StringBody
import grails.converters.JSON

class UserFixtures {

    def userFixtures(int c) {
        JSON.parse jsonClient.get("fixture/users?count=$c").bodyAsString
    }

    def customTeamFixtures(List l) {
        String str = l as JSON
        JSON.parse jsonClient.post("fixture/users/custom", new StringBody(str)).bodyAsString
    }

    def customTeamFixturesForTeam(long teamId, int count){

        def fixtures = []
        for (int i = 0; i < count; i++) {
            fixtures.add new User(
                    teamId: teamId,
                    alias: "user " + Character.toChars(Math.abs(new Random().nextInt() % 26) + 65) + " $i ",
                    ptsTotal: i,
                    ptsDelta: i,
                    wuTotal: i,
                    wuDelta: i,
                    rank: i,
                    rankDelta: i,
                    ptsDay: i,
                    ptsWeek: i,
                    rankTeam: i,
                    rankTeamDelta: i
            )

        }

        customTeamFixtures fixtures
    }
}
