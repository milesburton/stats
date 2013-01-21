package com.mb.stats.features.fixture

import grails.converters.JSON

class UserHistoryFixtures {

    def userHistoryFixtures(int c) {
        JSON.parse jsonClient.get("fixture/users/history?count=$c").bodyAsString
    }
}
