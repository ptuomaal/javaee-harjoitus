package fi.ptuomaal.ping.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.service.PongService;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("test")
public class TestResource {

    @Inject
    PongService service;

    @GET
    public String test() {
        return service.getResponseForTest();
    }
}
