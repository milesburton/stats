package com.mb.stats.features.fixture

import com.mb.stats.domain.Team
import com.popcornteam.restclient.request.StringBody
import grails.converters.JSON

class TeamFixtures {

    private def teamFixtures(int count) {
        JSON.parse jsonClient.get("fixture/teams?count=$count").bodyAsString
    }

    private def customTeamFixtures(List<Team> teamList) {
        String str = teamList as JSON
        JSON.parse jsonClient.post("fixture/teams/custom", new StringBody(str)).bodyAsString
    }
}
