package smw.backend;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Klasse Publisher um Nachrichten über MQTT zu senden
 * @author giesler
 * Datum: 05.07.2019
 */
public class Publisher implements Runnable{
    
    private static final String TOPIC = "/smw/pi/b8:27:eb:45:f5:2d/rgbled";
    private static final String TESTTOPIC = "/smw/backend/40:A3:CC:98:91:17/pir/";
    private static final String PASSWORD = "Smart/WB";
    private static final String USERNAME = "smart-workbench";
    public static String manual = "Test";
    
    public Publisher() throws MqttException{
        
    }
    
    @Override
    public void run(){
        System.out.println("Status: Publisher online");
    }
    
    public static void publish(String p_message, String p_topic, String box) throws MqttException{
        
        MqttClient client = new MqttClient("ssl://mqtt.iot-embedded.de:8883", MqttClient.generateClientId());
        
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(USERNAME);
        connOpts.setPassword(PASSWORD.toCharArray());
        client.connect(connOpts);
        MqttMessage message = new MqttMessage(p_message.getBytes());
        message.setQos(2);
        
        System.out.println(manual);

        client.publish(p_topic, message);
        
        client.disconnect();
    }
    
}
