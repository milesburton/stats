package com.mb.domain



import org.junit.*
import grails.test.mixin.*

@TestFor(FTeamsController)
@Mock(FTeams)
class FTeamsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/FTeams/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.FTeamsInstanceList.size() == 0
        assert model.FTeamsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.FTeamsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.FTeamsInstance != null
        assert view == '/FTeams/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/FTeams/show/1'
        assert controller.flash.message != null
        assert FTeams.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/FTeams/list'

        populateValidParams(params)
        def FTeams = new FTeams(params)

        assert FTeams.save() != null

        params.id = FTeams.id

        def model = controller.show()

        assert model.FTeamsInstance == FTeams
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/FTeams/list'

        populateValidParams(params)
        def FTeams = new FTeams(params)

        assert FTeams.save() != null

        params.id = FTeams.id

        def model = controller.edit()

        assert model.FTeamsInstance == FTeams
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/FTeams/list'

        response.reset()

        populateValidParams(params)
        def FTeams = new FTeams(params)

        assert FTeams.save() != null

        // test invalid parameters in update
        params.id = FTeams.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/FTeams/edit"
        assert model.FTeamsInstance != null

        FTeams.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/FTeams/show/$FTeams.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        FTeams.clearErrors()

        populateValidParams(params)
        params.id = FTeams.id
        params.version = -1
        controller.update()

        assert view == "/FTeams/edit"
        assert model.FTeamsInstance != null
        assert model.FTeamsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/FTeams/list'

        response.reset()

        populateValidParams(params)
        def FTeams = new FTeams(params)

        assert FTeams.save() != null
        assert FTeams.count() == 1

        params.id = FTeams.id

        controller.delete()

        assert FTeams.count() == 0
        assert FTeams.get(FTeams.id) == null
        assert response.redirectedUrl == '/FTeams/list'
    }
}
