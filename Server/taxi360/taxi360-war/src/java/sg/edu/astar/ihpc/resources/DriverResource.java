/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.astar.ihpc.resources;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import sg.edu.astar.taxi360.ejb.DriverEJB;
import sg.edu.astar.taxi360.entity.AvailableDriver;
import sg.edu.astar.taxi360.entity.Driver;
import sg.edu.astar.taxi360.entity.Passenger;
import sg.edu.astar.taxi360.entity.Ride;

/**
 * REST Web Service
 *
 * @author Hemanth 
 */
@Path("driver")
@RequestScoped
public class DriverResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DriverResource
     */
    public DriverResource() {
    }

    @EJB
    private DriverEJB driverEJB;

    
    @GET
    @Path("{id}")
    public Driver getDriver(@PathParam("id") Long id) {
        return driverEJB.getDriver(id);
    }
    
}
