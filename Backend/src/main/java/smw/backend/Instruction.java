/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.eclipse.paho.client.mqttv3.MqttException;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONObject;


/**
 * REST Web Service to communicate with the frontend
 * @author giesler
 */
@Path("instructions")
public class Instruction {
    
    
    @Context
    private UriInfo context;

    
    public Instruction() {
    }

    
    /**
     * PUT Method to handle incoming Messages from the Frontend
     * @param p_json
     * @throws org.eclipse.paho.client.mqttv3.MqttException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putHtml(JSONObject p_json) throws MqttException{
        
    }
    

            
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public String getJSON(){
       BuildJSON json_file = new BuildJSON();
       String json_string = json_file.initJSON();
       
       return json_string;
   }
}
