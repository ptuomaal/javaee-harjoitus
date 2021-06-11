package fi.ptuomaal.ping.controllers;

import fi.ptuomaal.ping.service.PongService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.logging.Logger;

@Path("/mvc/")
@Controller
@RequestScoped
public class PongController {

    private final static Logger logger = Logger.getLogger(PongController.class.getName());

    @Inject
    private Models models;

    @Inject
    private PongService pongService;

    @GET
    @Path("pongs")
    @View("pongs.jsp")
    public void allPongs() {
        logger.info("Ladataan pong-sivua");
        models.put("pongs", pongService.listPongs());
    }

    @GET
    @Path("pongs/{id}")
    @View("pong.jsp")
    public void pong(@PathParam("id") Long id) {
        models.put("pong", pongService.getPong(id));
    }

    @GET
    @Path("pongs/new")
    @View("new.jsp")
    public void newPong() {

    }

}
