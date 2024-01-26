
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class Eeprom_valueMsg extends JArduinoProtocolPacket {

	private byte value;
	
	public Eeprom_valueMsg(byte value) {
		setCommandID(JArduinoProtocol.EEPROM__VALUE);
		setByteValue(value);
		this.value = value;
	}
	
	public Eeprom_valueMsg(byte[] packet) {
		setPacketData(packet);
		value = buffer.get();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleEeprom_value(this);
	}

	@Override
	public String toString(){
		String myString = "eeprom_value:";
		myString += " [value: "+value+"]";
		return myString;
	}

	public byte getValue() {
		return value;
	}
	
}