package com.mb.stats.features.base

import com.popcornteam.restclient.RestClient
import com.popcornteam.restclient.factory.HttpClientFactory
import geb.spock.GebSpec
import org.apache.http.client.HttpClient

class RemoteServiceGebSpec extends GebSpec {

    RestClient jsonClient

    void setup() {
        HttpClientFactory httpClientFactory = new HttpClientFactory()
        HttpClient httpClient = httpClientFactory.makeThreadSafeHttpClient(2)

        jsonClient = new RestClient(baseUrl, [], httpClient)
    }
}
