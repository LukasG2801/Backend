/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author giesler
 * Date: 15.06.2019
 */
public class Subscriber implements Runnable {
    private static final String USERNAME = "smart-workbench";
    private static final String PASSWORD = "Smart/WB";
    private static final String TOPIC = "smw/workbench_1/pi_1/pir";
    
    //Wird ausgeführt sobald der Thread gestartet wird
    @Override
    public void run(){
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
                    System.out.print("Message arrived @ " + TOPIC + " ");
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
