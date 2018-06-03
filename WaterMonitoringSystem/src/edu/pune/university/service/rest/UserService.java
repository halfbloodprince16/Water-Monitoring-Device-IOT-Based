package edu.pune.university.service.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/user")
public class UserService {

	@POST
	@Path("/authenticate")
	@Produces(MediaType.TEXT_PLAIN)
	public String authenticateUser(@FormParam("userName") String userName, @FormParam("password") String password) {
		boolean authenticated = false;
		if (userName.equals("Maya") && password.equals("root")) {
			authenticated = true;
		}
		return new Gson().toJson(authenticated);
	}
}
