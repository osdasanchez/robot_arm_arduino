
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.JArduinoMessageHandler;
import mx.edu.uicui.jarduino.JArduinoProtocol;
import mx.edu.uicui.jarduino.JArduinoProtocolPacket;

public class PulseInResultMsg extends JArduinoProtocolPacket {

	private int value;

	public PulseInResultMsg(int value) {
		setCommandID(JArduinoProtocol.PULSE_IN_RESULT);
		setIntValue(value);
		this.value = value;
	}

	public PulseInResultMsg(byte[] packet) {
		setPacketData(packet);
		value = buffer.getShort();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handlePulseInResult(this);
	}

	@Override
	public String toString(){
		String myString = "pulseInResult:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public int getValue() {
		return value;
	}
	
}