
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class DigitalWriteMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
	private DigitalState value;
	
	public DigitalWriteMsg(DigitalPin pin, DigitalState value) {
		setCommandID(JArduinoProtocol.DIGITAL_WRITE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(value.getValue());
		this.value = value;
	}
	
	public DigitalWriteMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());		
		value = DigitalState.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleDigitalWrite(this);
	}

	@Override
	public String toString(){
		String myString = "digitalWrite:";
		myString += " [pin: "+pin+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
	public DigitalState getValue() {
		return value;
	}
	
}