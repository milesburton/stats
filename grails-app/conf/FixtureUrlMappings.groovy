import grails.util.GrailsUtil

class FixtureUrlMappings {

    static mappings = {

        if (["test", "development"].contains(GrailsUtil.getEnvironment())) {

            '/fixture/teams'(controller: 'Fixture', action: 'teams')
            '/fixture/teams/custom'(controller: 'Fixture', action: 'customTeams')

        }
    }
}
