package com.mb.stats.controller

import org.grails.datastore.mapping.model.PersistentEntity
import org.grails.datastore.mapping.query.Query

/**
 * Created with IntelliJ IDEA.
 * User: miles
 * Date: 13/01/13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
class FakeQuery extends org.grails.datastore.mapping.query.Query {

    FakeQuery() {
        super(null, null)
    }

    @Override
    protected List executeQuery(PersistentEntity entity, Query.Junction criteria) {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected void flushBeforeQuery() {

    }

    public int size() {
        -1
    }


}
