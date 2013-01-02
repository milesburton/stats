grails {
    mongo {
        host = "ds039427.mongolab.com"
        port = 39427
        username = "stats"
        password = "stats2012"
        databaseName = "stats"
    }
}

dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
    dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
    url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}

// environment specific settings
environments {
    development {
        grails {
            mongo {
                host = "cvps1.agileview.co.uk"
                port = 21
            }
        }


    }
    test {

    }
    production {

    }
}
