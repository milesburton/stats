hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}

dataSource {
    dbCreate = "validate"
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQLDialect

    readOnly = true

    uri = new URI(System.env.DATABASE_URL ?: "postgres://stats:stats@cvps2.agileview.co.uk/stats")

    url = "jdbc:postgresql://" + uri.host + uri.path
    username = uri.userInfo.split(":")[0]
    password = uri.userInfo.split(":")[1]
}
