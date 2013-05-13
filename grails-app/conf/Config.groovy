grails.project.groupId = appName
grails.mime.file.extensions = true 
grails.mime.use.accept.header = false
grails.mime.types = [
        all: '*/*',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        form: 'application/x-www-form-urlencoded',
        html: ['text/html', 'application/xhtml+xml'],
        js: 'text/javascript',
        json: ['application/json', 'text/json'],
        multipartForm: 'multipart/form-data',
        rss: 'application/rss+xml',
        text: 'text/plain',
        xml: ['text/xml', 'application/xml']
]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


grails.views.default.codec = "html" 
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"

grails.views.gsp.sitemesh.preprocess = true

grails.scaffolding.templates.domainSuffix = 'Instance'


grails.json.legacy.builder = false

grails.enable.native2ascii = true

grails.spring.bean.packages = []

grails.web.disable.multipart = false


grails.exceptionresolver.params.exclude = ['password']


grails.hibernate.cache.queries = false

disable.auto.recompile = false
grails.gsp.enable.reload = true

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        
    }
}

log4j = {

    error 'org.codehaus.groovy.grails.web.servlet',        
            'org.codehaus.groovy.grails.web.pages',          
            'org.codehaus.groovy.grails.web.sitemesh',       
            'org.codehaus.groovy.grails.web.mapping.filter', 
            'org.codehaus.groovy.grails.web.mapping',        
            'org.codehaus.groovy.grails.commons',            
            'org.codehaus.groovy.grails.plugins',            
            'org.codehaus.groovy.grails.orm.hibernate',      
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate'
}

environments {
    development {
        log4j = {
            
            debug 'grails.app'
        }
    }

    production {
        def catalinaBase = System.properties.getProperty('catalina.base')
        if (!catalinaBase) catalinaBase = '.'   
        def logDirectory = "${catalinaBase}/logs"

        log4j = {
            appenders {
                
                rollingFile name: 'tomcatLog', file: "${logDirectory}/${appName}.log".toString(), maxFileSize: '100KB'
                'null' name: 'stacktrace'
            }

            root {
                
                error 'tomcatLog'
                additivity = true
            }

            
            error tomcatLog: 'StackTrace'

            
            info 'grails.app'
        }
    }
}

stats {

    teams {
        order {
            options = ['asc', 'desc']
            defaultValue = 'desc'
        }

        sort {
            options = ["teamId", "alias", "ptsTotal", "ptsDelta", "wuTotal", "wuDelta", "rank", "rankDelta", "ptsDay", "ptsWeek"]
            defaultValue = "ptsTotal"
        }

        offset {
            defaultValue = 0
        }
        limit {
            defaultValue = 50
            min = 1
            max = 1000
        }
    }

    users {
        order {
            options = ['asc', 'desc']
            defaultValue = 'desc'
        }

        sort {
            options = ["teamId", "alias", "ptsTotal", "ptsDelta", "wuTotal", "wuDelta", "rank", "rankDelta", "ptsDay", "ptsWeek", "rankTeam", "rankTeamDelta"]
            defaultValue = "ptsTotal"
        }

        offset {
            defaultValue = 0
        }
        limit {
            defaultValue = 50
            min = 1
            max = 1000
        }
    }
}

cors.url.pattern = '/v1/*'

cache.headers.enabled = true