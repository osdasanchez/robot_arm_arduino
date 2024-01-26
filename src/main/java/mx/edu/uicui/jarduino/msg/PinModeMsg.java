
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class PinModeMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
	private PinMode mode;
	
	public PinModeMsg(DigitalPin pin, PinMode mode) {
		setCommandID(JArduinoProtocol.PIN_MODE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(mode.getValue());
		this.mode = mode;
	}
	
	public PinModeMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());		
		mode = PinMode.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handlePinMode(this);
	}

	@Override
	public String toString(){
		String myString = "pinMode:";
		myString += " [pin: "+pin+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
	public PinMode getMode() {
		return mode;
	}
	
}