/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author giesler
 */
public class PublishCaller {
        
    public static void publish(String p_message) throws MqttException{
        String password = "Smart/WB";
        String username = "smart-workbench";
        
        MqttClient client = new MqttClient("ssl://mqtt.iot-embedded.de:8883", MqttClient.generateClientId());
        
        
        
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        

         connOpts.setUserName(username);
        
         connOpts.setPassword(password.toCharArray());
        
         client.connect(connOpts);
        
        
        MqttMessage message = new MqttMessage(p_message.getBytes());
        message.setQos(0);
        client.publish("/smw/", message);
        
        client.disconnect();
    }

}
