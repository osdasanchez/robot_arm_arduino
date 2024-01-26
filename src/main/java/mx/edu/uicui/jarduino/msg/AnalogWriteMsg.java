
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class AnalogWriteMsg extends JArduinoProtocolPacket {

	private PWMPin pin;
	private byte value;
	
	public AnalogWriteMsg(PWMPin pin, byte value) {
		setCommandID(JArduinoProtocol.ANALOG_WRITE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setByteValue(value);
		this.value = value;
	}
	
	public AnalogWriteMsg(byte[] packet) {
		setPacketData(packet);
		pin = PWMPin.fromValue(buffer.get());		
		value = buffer.get();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAnalogWrite(this);
	}

	@Override
	public String toString(){
		String myString = "analogWrite:";
		myString += " [pin: "+pin+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public PWMPin getPin() {
		return pin;
	}
	
	public byte getValue() {
		return value;
	}
	
}