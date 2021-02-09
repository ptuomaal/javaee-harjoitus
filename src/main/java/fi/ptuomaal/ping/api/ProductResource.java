package fi.ptuomaal.ping.api;

import fi.ptuomaal.ping.entity.Product;
import fi.ptuomaal.ping.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/*
    ProductResource sisältää rajapinnat Product olioiden käsittelyyn
*/
@Path("product")
public class ProductResource {

    @Inject
    ProductService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProducts() {
        List<Product> list = service.getProducts();
        return list;
    }

    @GET
    @Path("/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findProductsByCategory(@PathParam("category") String category) {
        List<Product> list = service.getProductsByCategory(category);
        if (list.isEmpty())
            return Response.status(Status.NOT_FOUND).build();
        return Response.ok(list).build();
    }
}
