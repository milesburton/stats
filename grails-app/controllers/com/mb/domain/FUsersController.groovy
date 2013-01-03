package com.mb.domain

import org.springframework.dao.DataIntegrityViolationException

class FUsersController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [FUsersInstanceList: FUsers.list(params), FUsersInstanceTotal: FUsers.count()]
    }

    def create() {
        [FUsersInstance: new FUsers(params)]
    }

    def save() {
        def FUsersInstance = new FUsers(params)
        if (!FUsersInstance.save(flush: true)) {
            render(view: "create", model: [FUsersInstance: FUsersInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'FUsers.label', default: 'FUsers'), FUsersInstance.id])
        redirect(action: "show", id: FUsersInstance.id)
    }

    def show(Long id) {
        def FUsersInstance = FUsers.get(id)
        if (!FUsersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "list")
            return
        }

        [FUsersInstance: FUsersInstance]
    }

    def edit(Long id) {
        def FUsersInstance = FUsers.get(id)
        if (!FUsersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "list")
            return
        }

        [FUsersInstance: FUsersInstance]
    }

    def update(Long id, Long version) {
        def FUsersInstance = FUsers.get(id)
        if (!FUsersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (FUsersInstance.version > version) {
                FUsersInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'FUsers.label', default: 'FUsers')] as Object[],
                          "Another user has updated this FUsers while you were editing")
                render(view: "edit", model: [FUsersInstance: FUsersInstance])
                return
            }
        }

        FUsersInstance.properties = params

        if (!FUsersInstance.save(flush: true)) {
            render(view: "edit", model: [FUsersInstance: FUsersInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'FUsers.label', default: 'FUsers'), FUsersInstance.id])
        redirect(action: "show", id: FUsersInstance.id)
    }

    def delete(Long id) {
        def FUsersInstance = FUsers.get(id)
        if (!FUsersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "list")
            return
        }

        try {
            FUsersInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'FUsers.label', default: 'FUsers'), id])
            redirect(action: "show", id: id)
        }
    }
}
