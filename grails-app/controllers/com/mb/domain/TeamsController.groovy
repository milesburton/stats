package com.mb.domain

import grails.converters.JSON

class TeamsController {

    def index() {

        render Team.list(offset:10, max:20) as JSON

    }
}
