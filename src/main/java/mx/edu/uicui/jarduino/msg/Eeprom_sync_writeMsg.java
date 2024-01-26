
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class Eeprom_sync_writeMsg extends JArduinoProtocolPacket {

	private short address;
	private byte value;
	
	public Eeprom_sync_writeMsg(short address, byte value) {
		setCommandID(JArduinoProtocol.EEPROM__SYNC__WRITE);
		setShortValue(address);
		this.address = address;
		setByteValue(value);
		this.value = value;
	}
	
	public Eeprom_sync_writeMsg(byte[] packet) {
		setPacketData(packet);
		address = buffer.getShort();
		value = buffer.get();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleEeprom_sync_write(this);
	}

	@Override
	public String toString(){
		String myString = "eeprom_sync_write:";
		myString += " [address: "+address+"]";
		myString += " [value: "+value+"]";
		return myString;
	}

	public short getAddress() {
		return address;
	}
	
	public byte getValue() {
		return value;
	}
	
}