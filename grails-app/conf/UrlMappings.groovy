class UrlMappings {

    static mappings = {


        "/teams"(controller: 'Teams', action: 'list')
        "/teams/search/$q"(controller: 'Teams', action: 'search')
        "/teams/$teamId/users/search/$q" (controller: 'Users', action: 'searchWithinTeam')

        "/users" (controller: 'Users', action: 'list')
        "/users/search/$q" (controller: 'Users', action: 'search')

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
