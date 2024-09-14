package castellanos.joqsan.MQTT_Bomba;

import castellanos.joqsan.MQTT_Bomba.GUI.Lamina;
import castellanos.joqsan.MQTT_Bomba.GUI.Marco;

public class App {
	
    public static void main( String[] args ) {
    	
    	App.marco.setVisible(true);
    	
    	try {
			
			new MQTT_SubTemp("tcp://broker.hivemq.com", "castellanos/joqsan/temperatura").start();
			new MQTT_SubHum("tcp://broker.hivemq.com", "castellanos/joqsan/humedad").start();
			
			new Registro_Humedad().start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    
    public static Marco marco = new Marco(new Lamina(), 500, 200, "Bomba de agua");
}
