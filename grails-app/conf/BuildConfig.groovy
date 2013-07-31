grails.servlet.version = "3.0" 
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    
    inherits("global") {
        
        
    }
    log "error" 
    checksums true 

    def gebVersion = "0.9.0"
    def seleniumVersion = "2.21.0"

    repositories {
        inherits true 

        grailsPlugins()
        grailsHome()
        grailsCentral()

        
        mavenCentral()

        mavenRepo 'http://artifactory.milesburton.com/artifactory/remote-repos'
        mavenRepo 'http://artifactory.milesburton.com/artifactory/public'
        mavenRepo 'http://oss.sonatype.org/content/repositories/snapshots/'

    }
    dependencies {

        runtime 'postgresql:postgresql:8.4-702.jdbc3',
                'com.google.code.gson:gson:2.2.2'

        compile 'joda-time:joda-time:2.0'


        test("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
            exclude "xml-apis"
        }
        test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion",
             "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion",
             "org.spockframework:spock-grails-support:0.7-groovy-2.0",
             "org.gebish:geb-spock:$gebVersion",
             'com.popcornteam:restclient:1.0.130719.1658'

    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.0"
        runtime ":resources:1.1.6"
        runtime ":cors:1.0.3"


        build ":tomcat:$grailsVersion"

        compile ':cache:1.0.0'
        compile ":cache-headers:1.1.5"

        test(":spock:0.7") {
            exclude "spock-grails-support"
        }

        test ":geb:$gebVersion"
    }
}
