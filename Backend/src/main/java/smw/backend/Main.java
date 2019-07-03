/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Starting Threads to handle MQTT Connection
 * @author giesler
 */
public class Main {
    
    public static void main(String[] args) throws MqttException{
        
        //Subscriber Thread
        //handle incoming Messages 
        Thread subscriber = new Thread(new Subscriber());
        Thread publisher = new Thread(new Publisher());
        
        subscriber.start();
        publisher.start();
    }
 
}
