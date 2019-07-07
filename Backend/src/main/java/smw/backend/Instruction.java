/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.simple.JSONObject;

/**
 * REST Web Service ermöglicht die Kommunikation mit dem Frontend
 * @author giesler
 * Datum: 05.07.2019
 */
@Path("instructions")
public class Instruction {
    @Context
    private UriInfo context;

    
    public Instruction() {
    }

    /**
     * PUT Methode nimmt Anfragen aus dem Backend entgegen
     * Löst eine Montage aus und schaltet zwischen Schriten der Montage um
     * @param p_json
     * @throws org.eclipse.paho.client.mqttv3.MqttException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putHtml(JSONObject p_json) throws MqttException{
        
        //Entgegennehmen der Montage und des Schritts aus dem Frontend
        String manual = p_json.get("manual").toString();
        String step = p_json.get("step").toString();
        
        //Nur um zu loggen und einfacher auf Fehler übprüfen zu können
        System.out.println(manual);
        System.out.println(step);
        
        //Fallunterscheidung welche Montage gestartet wurde
        if("parallelschraubzwinge".equals(manual)){
            Schraubzwinge.sz_nextstep(Integer.parseInt(step));
        }
        if("rollbrett".equals(manual)){
            Rollbrett.rb_nextstep(Integer.parseInt(step));
        }
        
        
    }
    

            
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public String getJSON(){
       
       //GET Anfrage generiert und liefert die JSON die die Baupläne enthält
       BuildJSON json_file = new BuildJSON();
       String json_string = json_file.initJSON();
       
       return json_string;
   }
}
