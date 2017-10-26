package mapurlconstraints

class UrlMappings {

    static mappings = {
        "/v1/session/$sessionId(.$format)?" (
                controller: 'dummy',
                action: 'bySession',
                method: 'GET') {
            constraints {
                sessionId(matches: /\p{XDigit}{16}/)
            }
        }

        "/v1/$sessionId(.$format)?" (
                controller: 'dummy',
                action: 'bySessionOld',
                method: 'GET') {
            constraints {
                sessionId(matches: /\p{XDigit}{16}/)
            }
        }

        group "/v2", {
            "/session/$sessionId(.$format)?"(
                    controller: 'dummy',
                    action: 'bySession',
                    method: 'GET') {
                constraints {
                    sessionId(matches: /\p{XDigit}{16}/)
                }
            }

            "/$sessionId(.$format)?"(
                    controller: 'dummy',
                    action: 'bySessionOld',
                    method: 'GET') {
                constraints {
                    sessionId(matches: /\p{XDigit}{16}/)
                }
            }
        }

        group "/v3", {
            "/session/$sessionId(.$format)?"(
                    controller: 'dummy',
                    action: 'bySession',
                    method: 'GET') {
            }

            "/$sessionId(.$format)?"(
                    controller: 'dummy',
                    action: 'bySessionOld',
                    method: 'GET') {
                constraints {
                    sessionId(matches: /\p{XDigit}{16}/)
                }
            }
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
