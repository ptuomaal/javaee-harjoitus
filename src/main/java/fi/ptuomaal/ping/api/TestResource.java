package fi.ptuomaal.ping.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("test")
public class TestResource {

    @Inject
    PongService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return service.getResponseForTest();
    }
}
