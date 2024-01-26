
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class DigitalReadMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
	
	public DigitalReadMsg(DigitalPin pin) {
		setCommandID(JArduinoProtocol.DIGITAL_READ);
		setByteValue(pin.getValue());
		this.pin = pin;
	}
	
	public DigitalReadMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleDigitalRead(this);
	}

	@Override
	public String toString(){
		String myString = "digitalRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
}