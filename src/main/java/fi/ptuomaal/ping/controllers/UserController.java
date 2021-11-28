package fi.ptuomaal.ping.controllers;

import fi.ptuomaal.ping.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.logging.Logger;

@Path("/mvc/users")
@Controller
@RequestScoped
public class UserController {

    private final static Logger logger = Logger.getLogger(UserController.class.getName());

    @Inject
    private Models models;

    @Inject
    private UserService userService;

    @GET
    @Path("/")
    @View("users.jsp")
    public void allUsers() {
        logger.info("Ladataan users-sivua");
        models.put("users", userService.listUsers());
    }

}
