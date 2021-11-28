package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Defines the RESTful web service under path "ping"
 */
@Path("ping")
public class PongResource {

    @Inject
    PongService service;

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pong> ping(@PathParam("name") String name) {
        return service.getPongs(name);
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong getPong(@PathParam("id") Long id) {
        return service.getPong(id);
    }
}
