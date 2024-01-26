
package mx.edu.uicui.jarduino;

import mx.edu.uicui.jarduino.msg.*;

public abstract class JArduinoClientMessageHandler implements IJArduinoMessageHandler{
	@Override public void handleDigitalReadResult(DigitalReadResultMsg msg){ /* Nothing */ }
	@Override public void handleAnalogReadResult(AnalogReadResultMsg msg){ /* Nothing */ }
    @Override public void handlePulseInResult(PulseInResultMsg msg){ /* Nothing */ }
	@Override public void handlePong(PongMsg msg){ /* Nothing */ }
	@Override public void handleInterruptNotification(InterruptNotificationMsg msg){ /* Nothing */ }
	@Override public void handleEeprom_value(Eeprom_valueMsg msg){ /* Nothing */ }
	@Override public void handleEeprom_write_ack(Eeprom_write_ackMsg msg){ /* Nothing */ }
}
