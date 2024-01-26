
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class NoToneMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
	
	public NoToneMsg(DigitalPin pin) {
		setCommandID(JArduinoProtocol.NO_TONE);
		setByteValue(pin.getValue());
		this.pin = pin;
	}
	
	public NoToneMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleNoTone(this);
	}

	@Override
	public String toString(){
		String myString = "noTone:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
}