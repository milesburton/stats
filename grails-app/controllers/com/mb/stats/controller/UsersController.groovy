package com.mb.stats.controller

import com.mb.stats.ListParamSanitizerService
import com.mb.stats.UserService
import com.mb.stats.domain.User
import grails.converters.JSON

class UsersController {

    UserService userService
    ListParamSanitizerService listParamSanitizerService

    def index() {

        render User.list(offset:10, max:20) as JSON
    }

    def search(int teamId, String q) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
