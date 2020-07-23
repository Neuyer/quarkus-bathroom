package br.com.bathroom;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.bathroom.model.Toilet;
import br.com.bathroom.request.ToiletRequest;
import br.com.bathroom.service.ToiletService;

@Path("/toilets")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ToiletResource {

    @Inject
    ToiletService toiletService;

    @GET
    public List<Toilet> toilets() {

        return toiletService.lisToilets();
    }

    @POST
    public Toilet create(ToiletRequest tRequest) {

        return toiletService.create(tRequest);
    }

    @GET
    @Path("{id}")
    public Toilet findById(@PathParam("id") Long toiletID) {

        return toiletService.findByID(toiletID);
    }
}