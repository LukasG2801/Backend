/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import static javax.swing.UIManager.put;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.simple.JSONObject;

/**
 *
 * @author DOCKRT3
 */
public class Rollbrett {
    
    public Rollbrett(){
        
    }
    
    public static void rb_nextstep(int step)throws MqttException{
        JSONObject first_box = new JSONObject();
        JSONObject seccond_box = new JSONObject();
        
        if(step == 1){
            first_box.put("color", "green");
            seccond_box.put("color", "red");
        }
        
        if(step == 2){
            first_box.put("color", "red");
            seccond_box.put("color", "green");
        }
    }
}
