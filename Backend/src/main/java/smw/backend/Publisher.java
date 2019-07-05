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
public class Publisher implements Runnable{
    
    private static final String TOPIC = "/smw/pi/b8:27:eb:45:f5:2d/rgbled";
    private static final String TESTTOPIC = "/smw/backend/40:A3:CC:98:91:17/pir/";
    private static final String PASSWORD = "Smart/WB";
    private static final String USERNAME = "smart-workbench";
    
    public Publisher() throws MqttException{
        
    }
    
    @Override
    public void run(){
        System.out.println("Status: Publisher online");
    }
    
    public static void publish(String p_message, String p_topic) throws MqttException{
        
        MqttClient client = new MqttClient("ssl://mqtt.iot-embedded.de:8883", MqttClient.generateClientId());
        
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(USERNAME);
        connOpts.setPassword(PASSWORD.toCharArray());
        client.connect(connOpts);
        MqttMessage message = new MqttMessage(p_message.getBytes());
        message.setQos(2);
        client.publish(p_topic, message);
        
        client.disconnect();
    }
    
}
