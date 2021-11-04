package de.qaware.education.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class WorldController {


    @GET
    public String hello(){
        return "Hello world - I am gonna be the world controller!";
    }

    public static void main(String[] args) {
        System.out.println("I am gonna rule the world! ~ yours sincerely the WorldController");
    }
}
