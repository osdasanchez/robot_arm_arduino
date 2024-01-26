
package mx.edu.uicui.jarduino.sim;

import mx.edu.uicui.jarduino.sim.InteractiveJArduinoDataController;
import mx.edu.uicui.jarduino.sim.InteractiveJArduinoDataControllerClient;

public class TestJArduino {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InteractiveJArduinoDataController controller1 = new InteractiveJArduinoDataController();
		InteractiveJArduinoDataControllerClient controller2 = new InteractiveJArduinoDataControllerClient();
		controller1.register(controller2);
		controller2.register(controller1);
	}
}