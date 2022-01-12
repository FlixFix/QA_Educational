package de.qaware.education.adapter.inbound.http;

import de.qaware.education.core.RequestId;
import de.qaware.education.domain.user.business.UserDTO;
import de.qaware.education.domain.user.ports.inbound.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@ApplicationScoped
@Path("/users")
public class UserController {

    @Inject
    private UserService userService;

    @Inject
    private RequestId requestId;


    //GET /users/<id>
    @Path("/{id}")
    @GET
    public UserDTO getUser(@PathParam("id") long id) {
        return userService.getUserById(id);
    }
}
