package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.panache.common.Sort;

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
    public DailyReport getAll(@PathParam String country) {
    	System.out.println("got " + country);
    	return repo.findByCountry(country);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test/{country}")
    public List<DailyReport> getAggregate(@PathParam String country) {
  
    	return repo.listAll(Sort.descending("confirmedCases"));
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public long count() {
    	return repo.count();
    }
    
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/historical/{state}")
//    public String historical(@PathParam String state) throws JSONException, IOException {
//        return service.history(state);
//    }
    

}