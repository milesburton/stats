package com.mb.stats

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.Duration

class NextUpdateCalculator {

    DateTime calculateNextUpdate(long refreshInSeconds){


            DateMidnight midnight = new DateMidnight();
            DateTime now = new DateTime();
            Duration duration = new Duration(midnight, now);
            BigDecimal seconds = duration.toStandardSeconds().getSeconds();

            Long secondsTillNextUpdateFromMidnight = (Math.ceil(seconds/refreshInSeconds) * refreshInSeconds)

            midnight.toDateTime().plus(secondsTillNextUpdateFromMidnight)
    }
}
