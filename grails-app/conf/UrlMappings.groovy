class UrlMappings {

    static mappings = {


        "/v1/teams"(controller: 'Teams', action: 'list')
        "/v1/teams/search/$q"(controller: 'Teams', action: 'search')

        "/v1/teams/$teamId/users/$alias/history" (controller: 'UserHistory', action: 'listBetween')

        "/v1/teams/$teamId/history" (controller: 'TeamHistory', action: 'listBetween')

        "/v1/users" (controller: 'Users', action: 'list')
        "/v1/users/search/$q" (controller: 'Users', action: 'search')
        "/v1/teams/$teamId/users" (controller: 'Users', action: 'listForTeam')
        "/v1/teams/$teamId/users/search/$q" (controller: 'Users', action: 'searchWithinTeam')

        "/"(view: "/index")
        "500"(view: '/error')

        "/docs/get-teams" (view: "/docs/get-teams")
    }
}
