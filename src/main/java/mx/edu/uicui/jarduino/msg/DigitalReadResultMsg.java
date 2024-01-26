
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class DigitalReadResultMsg extends JArduinoProtocolPacket {

	private DigitalState value;
	
	public DigitalReadResultMsg(DigitalState value) {
		setCommandID(JArduinoProtocol.DIGITAL_READ_RESULT);
		setByteValue(value.getValue());
		this.value = value;
	}
	
	public DigitalReadResultMsg(byte[] packet) {
		setPacketData(packet);
		value = DigitalState.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleDigitalReadResult(this);
	}

	@Override
	public String toString(){
		String myString = "digitalReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public DigitalState getValue() {
		return value;
	}
	
}