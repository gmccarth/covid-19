package org.acme;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("/api/countries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryResource {

    @Inject CountryService countryService;

    @GET
    public List<Country> list() {
        return countryService.list();
    }

    @GET
    @Path("/{provinceState}")
    public List<Country> provinceState(@PathParam String provinceState) {
        return countryService.getByProvinceState(provinceState);
    }


    @POST
    public List<Country> add(Country country) {
        countryService.add(country);
        return list();
    }
}