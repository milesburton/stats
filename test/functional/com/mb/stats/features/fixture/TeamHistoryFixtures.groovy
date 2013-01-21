package com.mb.stats.features.fixture

import grails.converters.JSON

class TeamHistoryFixtures {

    def teamHistoryFixtures(int c) {
        JSON.parse jsonClient.get("fixture/teams/history?count=$c").bodyAsString
    }
}
