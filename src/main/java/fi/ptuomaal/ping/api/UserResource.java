package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.User;
import fi.ptuomaal.ping.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("/firstName/{firstName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping(@PathParam("firstName") String firstName) {
        List<User> users = service.getUsers(firstName);
        if (users.isEmpty()) {
            return Response.status(404).build();
        } else {
            return Response.ok(users).build();
        }
    }
}
