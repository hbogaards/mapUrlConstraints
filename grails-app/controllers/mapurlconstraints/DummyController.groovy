package mapurlconstraints

import org.springframework.http.HttpStatus

class DummyController {

    static allowedMethods = [bySession   : ['GET'],
                             bySessionOld: ['GET']]
    static responseFormats = ['json']

    def bySessionOld(String sessionId) {
        log.info("bySessionOld($sessionId)")

        respond incidentBySessieIdOld: sessionId
    }

    def bySession(String sessionId) {
        log.info("bySession($sessionId)")

        respond incidentBySessieId: sessionId
    }
}


