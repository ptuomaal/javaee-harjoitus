package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/*
    PongResource sisältää rajapinnat Pong olioiden käsittelyyn
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
        return StringUtils.join(pongs, ",");
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pong getPong(@PathParam("id") Long id) {
        return service.getPong(id);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Pong createPong(@FormParam("name") String name) {
        return service.createPong(name);
    }

    @POST
    @Path("/{id}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean deletePong(@PathParam("id") Long id) {
        return service.deletePong(id);
    }
}
