package com.mb.domain

import org.springframework.dao.DataIntegrityViolationException

class FTeamsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [FTeamsInstanceList: FTeams.list(params), FTeamsInstanceTotal: FTeams.count()]
    }

    def create() {
        [FTeamsInstance: new FTeams(params)]
    }

    def save() {
        def FTeamsInstance = new FTeams(params)
        if (!FTeamsInstance.save(flush: true)) {
            render(view: "create", model: [FTeamsInstance: FTeamsInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'FTeams.label', default: 'FTeams'), FTeamsInstance.id])
        redirect(action: "show", id: FTeamsInstance.id)
    }

    def show(Long id) {
        def FTeamsInstance = FTeams.get(id)
        if (!FTeamsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "list")
            return
        }

        [FTeamsInstance: FTeamsInstance]
    }

    def edit(Long id) {
        def FTeamsInstance = FTeams.get(id)
        if (!FTeamsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "list")
            return
        }

        [FTeamsInstance: FTeamsInstance]
    }

    def update(Long id, Long version) {
        def FTeamsInstance = FTeams.get(id)
        if (!FTeamsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (FTeamsInstance.version > version) {
                FTeamsInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'FTeams.label', default: 'FTeams')] as Object[],
                          "Another user has updated this FTeams while you were editing")
                render(view: "edit", model: [FTeamsInstance: FTeamsInstance])
                return
            }
        }

        FTeamsInstance.properties = params

        if (!FTeamsInstance.save(flush: true)) {
            render(view: "edit", model: [FTeamsInstance: FTeamsInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'FTeams.label', default: 'FTeams'), FTeamsInstance.id])
        redirect(action: "show", id: FTeamsInstance.id)
    }

    def delete(Long id) {
        def FTeamsInstance = FTeams.get(id)
        if (!FTeamsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "list")
            return
        }

        try {
            FTeamsInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'FTeams.label', default: 'FTeams'), id])
            redirect(action: "show", id: id)
        }
    }
}
