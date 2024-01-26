
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class AnalogReferenceMsg extends JArduinoProtocolPacket {

	private AnalogReference type;
	
	public AnalogReferenceMsg(AnalogReference type) {
		setCommandID(JArduinoProtocol.ANALOG_REFERENCE);
		setByteValue(type.getValue());
		this.type = type;
	}
	
	public AnalogReferenceMsg(byte[] packet) {
		setPacketData(packet);
		type = AnalogReference.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAnalogReference(this);
	}

	@Override
	public String toString(){
		String myString = "analogReference:";
		myString += " [type: "+type+"]";
		return myString;
	}

	public AnalogReference getType() {
		return type;
	}
	
}