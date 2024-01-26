
package mx.edu.uicui.jarduino;

import mx.edu.uicui.jarduino.msg.*;

public abstract class JArduinoMessageHandler implements IJArduinoMessageHandler{
	@Override public void handlePinMode(PinModeMsg msg){ /* Nothing */ }
	@Override public void handleDigitalRead(DigitalReadMsg msg){ /* Nothing */ }
	@Override public void handleDigitalWrite(DigitalWriteMsg msg){ /* Nothing */ }
	@Override public void handleAnalogReference(AnalogReferenceMsg msg){ /* Nothing */ }
	@Override public void handleAnalogRead(AnalogReadMsg msg){ /* Nothing */ }
	@Override public void handleAnalogWrite(AnalogWriteMsg msg){ /* Nothing */ }
	@Override public void handleTone(ToneMsg msg){ /* Nothing */ }
	@Override public void handleNoTone(NoToneMsg msg){ /* Nothing */ }
    @Override public void handlePulseIn(PulseInMsg msg){ /* Nothing */ }
	@Override public void handlePing(PingMsg msg){ /* Nothing */ }
	@Override public void handleAttachInterrupt(AttachInterruptMsg msg){ /* Nothing */ }
	@Override public void handleDetachInterrupt(DetachInterruptMsg msg){ /* Nothing */ }
	@Override public void handleEeprom_read(Eeprom_readMsg msg){ /* Nothing */ }
	@Override public void handleEeprom_sync_write(Eeprom_sync_writeMsg msg){ /* Nothing */ }
	@Override public void handleEeprom_write(Eeprom_writeMsg msg){ /* Nothing */ }
}
