package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.User;
import fi.ptuomaal.ping.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Defines the RESTful web service under path "user"
 */
@Path("user")
public class UserResource {

    @Inject
    UserService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listUsers() {
        return service.listUsers();
    }
}
