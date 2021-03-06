/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.astar.ihpc.resources;

import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import sg.edu.astar.taxi360.bo.RideFacade;
import sg.edu.astar.taxi360.ejb.DriverEJB;
import sg.edu.astar.taxi360.ejb.PassengerEJB;
import sg.edu.astar.taxi360.entity.Ride;

/**
 * REST Web Service
 *
 * @author Thilak
 */
@Path("ride")
@RequestScoped
public class RideResource {

    @Context
    private UriInfo context;
    @EJB
    private DriverEJB driverEJB;
    @EJB
    private PassengerEJB passengerEJB;
    @EJB
    private RideFacade rideFacade;

    /**
     * Creates a new instance of RideResource
     */
    public RideResource() {
    }
    
    @GET
    @Path("/{id}")
    public Ride getRide(@PathParam("id") String id) {
         return rideFacade.find(id);
    }

     @POST
    public Ride createRide(Ride ride) throws IOException {
        ride.setEndStatus("-1");
        return driverEJB.createRide(ride);
    }

    @POST
    @Path("end")
    public Ride endRide(Ride ride) throws IOException {
        ride.setEndStatus("0");
        return driverEJB.endRide(ride);
    }
    
    @PUT
    @Path("rating")
    public void updateRating(Ride ride) throws IOException{
        driverEJB.updateRating(ride);
    }
    
    @PUT
    @Path("passengerNotFound")
    public void passengerNotFound(Ride ride) throws IOException{
        driverEJB.passengerNotFound(ride);
    }
    
     @POST
    @Path("passengerRating")
    public void updatePassengerRating(Ride ride) throws IOException{
         passengerEJB.updateRating(ride);
    }
    
    @PUT
    @Path("updateDriverLoc")
    public void updateDriverLocation(Ride ride){
        driverEJB.updateDriverLocation(ride);
    }
    
//    @PUT
//    @Path("reachedNear")
//    public void reachedNear(Ride ride){
//        driverEJB.reachedNear(ride);          
//    }
    
    
    @PUT
    @Path("reachedPassenger")
    public void reachedPassenger(Ride ride){
        driverEJB.reachedPassenger(ride);          
    }
    
    
     @PUT
     @Path("start")
    public void startRide(Ride ride) throws IOException {
        //ride.setEndStatus("-1");
         driverEJB.startRide(ride);
    }

}
