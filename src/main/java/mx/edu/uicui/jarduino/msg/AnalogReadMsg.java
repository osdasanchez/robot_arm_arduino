
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class AnalogReadMsg extends JArduinoProtocolPacket {

	private AnalogPin pin;
	
	public AnalogReadMsg(AnalogPin pin) {
		setCommandID(JArduinoProtocol.ANALOG_READ);
		setByteValue(pin.getValue());
		this.pin = pin;
	}
	
	public AnalogReadMsg(byte[] packet) {
		setPacketData(packet);
		pin = AnalogPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAnalogRead(this);
	}

	@Override
	public String toString(){
		String myString = "analogRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public AnalogPin getPin() {
		return pin;
	}
	
}