package smw.backend;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.simple.JSONObject;

/**
 * Klasse für Werkstück Schraubzwinge
 * @author giesler
 * Datum: 05.07.2019
 */
public class Schraubzwinge {
    public static boolean p_first_box = false;
    
    public Schraubzwinge(){
        
    }
    
    public static void sz_nextstep(int step) throws MqttException{
        JSONObject first_box = new JSONObject();
        JSONObject seccond_box = new JSONObject();
        
        Publisher.manual = "Schraubzwinge";

        if(step == 1){
            first_box.put("color","blue");
            seccond_box.put("color", "red");

        }
        
        if(step == 2){
            first_box.put("color","red");
            seccond_box.put("color", "blue");

        }
        
        if(step == 3){
            first_box.put("color", "red");
            seccond_box.put("color", "blue");
        }
        Publisher.publish(first_box.toString(), "smw/workbench_1/pi_1/led", "");
        Publisher.publish(seccond_box.toString(), "smw/workbench_1/pi_2/led", "");
    }
}
