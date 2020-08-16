package com.rest;

import java.util.Date;

import java.util.List;


import javax.ws.rs.Consumes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




import com.dao.UserDAO;



import com.dto.User;




@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @Path("regUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(User user){
    	System.out.println("Data received in register User " + user);
    	UserDAO userDao = new UserDAO();
    	userDao.register(user);
    }
    	
    @Path("UserLogin/{mailId}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByMailId(@PathParam("mailId") String mailId , @PathParam("password") String password){
    	System.out.println("Recieved in getUserByMailId : " + mailId + password); 
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserByMailId(mailId,password);	
		 
		return user;
		}
    /*@Path("getAllInNse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NSE> getAllNse() {
    	System.out.println("Recieved in getAllNse "); 
		NseDAO NseDao = new NseDAO();
		List<NSE> nse = NseDao.getAllNse();
		System.out.println(nse); 
		return nse;

	}*/
    /*@Path("regBse")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String registerBse() {
		BombaySE bse = new BombaySE();	
		bse.setDate("1/21/14");
		bse.setAdj_Close("12345");
		bse.setOpen("45612");
		bse.setLow("12345");
		bse.setHigh("78945");
		bse.setClose("45612");
		bse.setVolume("777756");
		
		BombaySEDAO bseDao = new BombaySEDAO();
		bseDao.register(bse);
		return "Success";
	}*/
    
}
