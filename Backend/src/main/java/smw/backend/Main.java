package smw.backend;

import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Startet Threads um MQTT Nachrichten abzufangen und aufzuzeichnen
 * Dient hauptsächlich zur Fehlersuche
 * @author giesler
 * Datum: 05.07.2019
 */
public class Main {
    
    public static boolean a_first_box = false;
    
    public static void main(String[] args) throws MqttException{
        
        //Subscriber Thread
        //Fängt Nachrichten ab und gibt sie in der Konsole aus
        //Thread subscriber = new Thread(new Subscriber());

        Thread publisher = new Thread(new Publisher());
 
        //subscriber.start();
        //subscriber_first_box.start();
        //subscriber.start();
        //subscriber_b2.start();
        //publisher.start();
    }
 
}
