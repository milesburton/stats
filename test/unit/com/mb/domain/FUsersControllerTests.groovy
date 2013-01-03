package com.mb.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(FUsersController)
@Mock(FUsers)
class FUsersControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/FUsers/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.FUsersInstanceList.size() == 0
        assert model.FUsersInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.FUsersInstance != null
    }

    void testSave() {
        controller.save()

        assert model.FUsersInstance != null
        assert view == '/FUsers/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/FUsers/show/1'
        assert controller.flash.message != null
        assert FUsers.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/FUsers/list'

        populateValidParams(params)
        def FUsers = new FUsers(params)

        assert FUsers.save() != null

        params.id = FUsers.id

        def model = controller.show()

        assert model.FUsersInstance == FUsers
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/FUsers/list'

        populateValidParams(params)
        def FUsers = new FUsers(params)

        assert FUsers.save() != null

        params.id = FUsers.id

        def model = controller.edit()

        assert model.FUsersInstance == FUsers
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/FUsers/list'

        response.reset()

        populateValidParams(params)
        def FUsers = new FUsers(params)

        assert FUsers.save() != null

        // test invalid parameters in update
        params.id = FUsers.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/FUsers/edit"
        assert model.FUsersInstance != null

        FUsers.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/FUsers/show/$FUsers.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        FUsers.clearErrors()

        populateValidParams(params)
        params.id = FUsers.id
        params.version = -1
        controller.update()

        assert view == "/FUsers/edit"
        assert model.FUsersInstance != null
        assert model.FUsersInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/FUsers/list'

        response.reset()

        populateValidParams(params)
        def FUsers = new FUsers(params)

        assert FUsers.save() != null
        assert FUsers.count() == 1

        params.id = FUsers.id

        controller.delete()

        assert FUsers.count() == 0
        assert FUsers.get(FUsers.id) == null
        assert response.redirectedUrl == '/FUsers/list'
    }
}
