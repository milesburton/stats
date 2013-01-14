import grails.util.GrailsUtil

class UrlMappings {

    static mappings = {

        if (["test", "development"].contains(GrailsUtil.getEnvironment())) {

            '/fixture/teams'(controller: 'Fixture', action: 'teams')

        }
    }
}
