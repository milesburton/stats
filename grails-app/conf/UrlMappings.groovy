class UrlMappings {

    static mappings = {


        '/teams'(controller: 'Teams', action: 'index')
        '/teams/search'(controller: 'Teams', action: 'search')

        "/"(view: "/index")
        "500"(view: '/error')
    }
}
