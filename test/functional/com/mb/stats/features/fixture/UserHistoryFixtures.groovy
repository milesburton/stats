package com.mb.stats.features.fixture

import com.mb.stats.domain.User
import com.popcornteam.restclient.request.StringBody
import grails.converters.JSON

class UserHistoryFixtures {

    def userHistoryFixtures(int c) {
        JSON.parse jsonClient.get("fixture/users/history?count=$c").bodyAsString
    }
}
