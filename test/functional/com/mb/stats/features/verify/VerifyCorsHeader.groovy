package com.mb.stats.features.verify

import com.popcornteam.restclient.response.RestResponse

class VerifyCorsHeader {

    void verifyCorsHeader(RestResponse r) {

        def allowedHeaders = [
                "Access-Control-Allow-Origin": '*'
        ]

        println r.headers.name*.toLowerCase()

        allowedHeaders.keySet().each { def headerName ->

            def header = r.headers.find { it.name.toLowerCase() == headerName.toLowerCase() }

            if (!header){
                println "Could not find ${headerName.toLowerCase()}"
            }

            assert header.value == allowedHeaders[headerName]
        }
    }
}
