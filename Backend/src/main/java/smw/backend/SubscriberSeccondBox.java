package smw.backend;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.*;
import org.json.simple.JSONObject;

/**
 * Subscriber Client für die zweite Box
 * @author giesler
 * Date: 15.06.2019
 */
public class SubscriberSeccondBox{
    private static final String USERNAME = "smart-workbench";
    private static final String PASSWORD = "Smart/WB";
    private static final String TOPIC = "smw/workbench_1/pi_2/pir";
    static boolean active = false;
    
    //Wird ausgeführt sobald der Thread gestartet wird
    public static void main(String[] args){
        System.out.println("Status: SubscriberSeccondBox online");
        try {
            MqttClient client = new MqttClient("ssl://mqtt.iot-embedded.de:8883", MqttClient.generateClientId());
            
            MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
            client.connect(connOpts);
            client.subscribe(TOPIC);
            
            client.setCallback(new MqttCallback(){
                
                @Override
                public void connectionLost(Throwable throwable){}
                
                //Messages entgegen nehmen und verarbeiten
                @Override
                public void messageArrived(String t, MqttMessage m) throws Exception {
                    JSONObject json_first_box = new JSONObject();
                    json_first_box.put("color", "green");  
                    System.out.print("Message arrived @ " + TOPIC + " ");
                    Publisher.publish(json_first_box.toString(), "smw/workbench_1/pi_2/led", "B2");
                    System.out.println(new String(m.getPayload()));  
                }
                
                @Override
                public void deliveryComplete(IMqttDeliveryToken t){}
            });
            
        //Mqtt Exceptions abfangen, da Methode run() kein Exception Handling zulässt, hier als try-catch-Block
        } catch (MqttException ex) {
            Logger.getLogger(Subscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    //Some Options ti build an stable Connection to the MQTT Broker
    private static MqttConnectOptions setUpConnectionOptions(String username, String password){
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        return connOpts;
    }
}
