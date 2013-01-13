package com.mb.stats.controller

import com.mb.stats.domain.User
import grails.converters.JSON

class UsersController {

    def index() {

        render User.list(offset:10, max:20) as JSON
    }
}
