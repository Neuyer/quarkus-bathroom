package br.com.bathroom;

import br.com.bathroom.model.Bog;
import br.com.bathroom.model.Toilet;
import br.com.bathroom.request.ToiletRequest;
import br.com.bathroom.service.ToiletService;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/toilets")
public class ToiletResource {

    @Inject
    ToiletService toiletService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON_PATCH_JSON)
    public List<Toilet> toilets() {

        return toiletService.lisToilets();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Toilet create(ToiletRequest tRequest) {

        return toiletService.create(tRequest);
    } 

    // @GET()
    // @Consumes(value = MediaType.APPLICATION_JSON)
    // @Produces(value =  MediaType.APPLICATION_JSON)
    // public Toilet findById(@PathParam("id") Long toiletID) {

    //     return toiletService.findByID(toiletID);
    // }
}