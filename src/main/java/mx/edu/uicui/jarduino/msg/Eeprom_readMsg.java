
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class Eeprom_readMsg extends JArduinoProtocolPacket {

	private short address;
	
	public Eeprom_readMsg(short address) {
		setCommandID(JArduinoProtocol.EEPROM__READ);
		setShortValue(address);
		this.address = address;
	}
	
	public Eeprom_readMsg(byte[] packet) {
		setPacketData(packet);
		address = buffer.getShort();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleEeprom_read(this);
	}

	@Override
	public String toString(){
		String myString = "eeprom_read:";
		myString += " [address: "+address+"]";
		return myString;
	}

	public short getAddress() {
		return address;
	}
	
}