package de.qaware.education.adapter.inbound.http;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@ApplicationScoped
@Path("/hello")
public class WorldController {

    private boolean test;

    @Inject
    private UserController users;

    @GET
    public String hello(){
        return "Hello world - I am gonna be the world controller! ~ yours sincerely the WorldController";
    }

}
