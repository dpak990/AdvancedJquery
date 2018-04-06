package advjq

import grails.converters.JSON

/**
 * Created by neetesh on 2/3/16.
 */
class ContactController {

    def index() {
        [contacts: Contact.list()]
    }

    def add() {
    }

    def save(Contact contact) {
        Thread.sleep(3000)
        render contact.save(flush: true, failOnError: true) as JSON
    }

    def updateCircle(Long id, String circle) {
        Contact contact = Contact.get(id)
        contact.circle = circle
        render contact.save(flush: true) as JSON
    }


    def isContactExists() {
        Contact contact = Contact.findByMobile(params.mobileField)
        String result = contact ? false : true
        render result
    }

}
