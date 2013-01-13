package com.mb.stats.controller

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mb.stats.domain.Team
import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory
import com.popcornteam.restclient.response.RestResponse
import geb.spock.GebSpec
import grails.converters.JSON
import org.apache.http.client.HttpClient
import spock.lang.Unroll

import java.lang.reflect.Type

class TeamsControllerIntSpec extends GebSpec {

    RestClient jsonClient
    def fixtures

    void setup() {
        HttpClientFactory httpClientFactory = new HttpClientFactory()
        HttpClient httpClient = httpClientFactory.makeThreadSafeHttpClient(2)

        jsonClient = new RestClient(baseUrl, [], httpClient)

        createFixturesList(100)
    }

    def "list"() {

        when:
        RestResponse r = jsonClient.get('teams')

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 100
        j.results == fixtures[0..49]
    }

    @Unroll
    def "list sort by #sort #order"() {

        given:
        fixtures.sort { it.hasProperty(sort) ? it."${sort}" : it.ptsTotal }
        order != "asc" ? fixtures.reverse(true) : ''

        when:
        RestResponse r = jsonClient.get("teams?sort=$sort&order=$order")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 100
        j.results == fixtures[0..49]

        where:
        sort        | order
        "teamId"    | "desc"
        "ptsTotal"  | "desc"
        "ptsDelta"  | "desc"
        "wuTotal"   | "desc"
        "wuDelta"   | "desc"
        "rank"      | "desc"
        "rankDelta" | "desc"
        "ptsDay"    | "desc"
        "ptsWeek"   | "desc"
        "garbage"   | "desc"
        "ptsDay"    | "garbage"
        "teamId"    | "asc"
        "ptsTotal"  | "asc"
        "ptsDelta"  | "asc"
        "wuTotal"   | "asc"
        "wuDelta"   | "asc"
        "rank"      | "asc"
        "rankDelta" | "asc"
        "ptsDay"    | "asc"
        "ptsWeek"   | "asc"
        "garbage"   | "asc"
        "ptsweek"   | "asc"

    }

    @Unroll
    def "list illegal offset #offset and limit #limit"() {

        given:
        createFixturesList(1010)

        when:
        RestResponse r = jsonClient.get("teams?limit=$limit&offset=$offset")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 1010
        j.results == fixtures[expectedOffset..(expectedLimit - 1)]

        where:
        offset | expectedOffset | limit | expectedLimit
        -100   | 0              | -1    | 1
        -1     | 0              | -100  | 1
        0      | 0              | 10000 | 1000
        0      | 0              | 1001  | 1000
    }

    @Unroll
    def "list offset #offset and limit #limit"() {

        when:
        RestResponse r = jsonClient.get("teams?limit=$limit&offset=$offset")

        then:
        def j = JSON.parse r.bodyAsString
        j.total == 100
        j.results == fixtures[offset..offset + (limit - 1)]

        where:
        offset | limit
        0      | 50
        1      | 50
        10     | 50
        50     | 50
        0      | 100
        0      | 10
        0      | 9
        1      | 9
        9      | 9
        50     | 10
    }

    private void createFixturesList(int count) {
        fixtures = JSON.parse jsonClient.get("fixture/teams?count=$count").bodyAsString
    }
}
