
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class AnalogReadResultMsg extends JArduinoProtocolPacket {

	private short value;
	
	public AnalogReadResultMsg(short value) {
		setCommandID(JArduinoProtocol.ANALOG_READ_RESULT);
		setShortValue(value);
		this.value = value;
	}
	
	public AnalogReadResultMsg(byte[] packet) {
		setPacketData(packet);
		value = buffer.getShort();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAnalogReadResult(this);
	}

	@Override
	public String toString(){
		String myString = "analogReadResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public short getValue() {
		return value;
	}
	
}