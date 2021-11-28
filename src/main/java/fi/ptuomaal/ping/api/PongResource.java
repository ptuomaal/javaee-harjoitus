package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Produces(MediaType.TEXT_HTML)
    public String ping(@PathParam("name") String name) {
        List<Pong> pongs = service.getPongs(name);
        String htmlList = "<ul>";
        for (Pong p : pongs) {
            htmlList += "<li>" + p.getId() + ": " + p.getName() + "</li>";
        }
        String page = "<html><body>" + htmlList + "</body></html>";
        return page;
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong getPong(@PathParam("id") Long id) {
        return service.getPong(id);
    }

    @POST
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong createPong(@PathParam("name") String name) {
        return service.createPong(name);
    }

    @DELETE
    @Path("/id/{id}")
    public void deletePong(@PathParam("id") Long id) {
        service.deleteById(id);
    }

}
