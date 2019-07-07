package smw.backend;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.*;

/**
 * Klasse Subscriber dient hauptsächlich dazu, alle Nachrichten 
 * aufzuzeichnen die über das Topic smw/ und alle Untertopics gesendet werden 
 * @author giesler
 * Date: 15.06.2019
 */
public class Subscriber{
    private static final String USERNAME = "smart-workbench";
    private static final String PASSWORD = "Smart/WB";
    private static final String TOPIC = "smw/#";
    public static boolean flag_1;
    
    
    public static void main(String[] args){
        System.out.println("Status: Subscriber onlinee");
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
                    System.out.print("Message arrived @ " + t + " ");
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
