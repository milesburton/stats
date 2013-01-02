package com.mb.stats

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

@ToString
@EqualsAndHashCode
class DailyUserSummary {

  //  static mapWith = "hibernate"

    String name
    Long credit
    Long total
    Long teamId
    Long timestamp

    static constraints = {
    }
}
