package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/reports")
public class CovidResource {

//	@Inject
//	CovidService service;
	
	@Inject
	ReportRepository repo;
	
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/{state}")
//    public String daily(@PathParam String state) throws JSONException, IOException {
//        return service.daily(state);
//    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/country/{country}")
    public int getCountry(@PathParam String country) {
    	return repo.findByCountry(country).getConfirmed();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/historical/{state}")
//    public String historical(@PathParam String state) throws JSONException, IOException {
//        return service.history(state);
//    }
    

}