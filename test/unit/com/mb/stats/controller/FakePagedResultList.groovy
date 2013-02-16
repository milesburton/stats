package com.mb.stats.controller

import grails.gorm.PagedResultList

/**
 * Created with IntelliJ IDEA.
 * User: miles
 * Date: 13/01/13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
class FakePagedResultList extends PagedResultList {

    FakePagedResultList() {
        super(new FakeQuery())
    }

    @Override
    public int getTotalCount() {
        0
    }

    @Override
    public Object get(int i) {

    }

    @Override
    public Object set(int i, Object o) {

    }

    @Override
    public Object remove(int i) {

    }

    @Override
    public void add(int i, Object o) {

    }


    @Override
    public int size() {
        0
    }
}
