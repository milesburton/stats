package com.mb.stats.features.verify

import com.mb.stats.features.fixture.NextUpdateIntervalFixtures
import com.popcornteam.restclient.response.RestResponse
import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.Duration

import java.text.SimpleDateFormat

class VerifyExpiresHeader {

    void verifyCacheExpireByNextUpdate(RestResponse r) {

        def expiresHeader = r.headers.find { it.name.toLowerCase() == 'expires' }
        assert parseToDate(expiresHeader.value) == calculate()
    }


    Date calculate() {

        def midnight = new DateMidnight()
        Duration duration = new Duration(midnight, new DateTime())

        int minutesTillNextUpdate = (Math.ceil(duration.getStandardMinutes() / NextUpdateIntervalFixtures.updateIntervalInMinutes) * NextUpdateIntervalFixtures.updateIntervalInMinutes)

        midnight.toDateTime().plusMinutes(minutesTillNextUpdate + NextUpdateIntervalFixtures.updateDuration).toDate()
    }

    Date parseToDate(String dateString) {

        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
        format.parse(dateString);
    }
}
