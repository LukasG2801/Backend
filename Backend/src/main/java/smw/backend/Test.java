/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *  Test Class to test the communication with the MQTT Broker
 * @author giesler
 */
public class Test {
    public static void main(String[] args) throws MqttException{
        Publisher publisher = new Publisher();
        Publisher.publish("test von Lukas", "smw/backend/40:A3:CC:98:91:17/pir/");
    }
    
    public static void publish(String p_test) throws MqttException{
        Publisher publisher = new Publisher();
        
    }
}
