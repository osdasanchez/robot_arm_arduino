
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class Eeprom_write_ackMsg extends JArduinoProtocolPacket {

	
	public Eeprom_write_ackMsg() {
		setCommandID(JArduinoProtocol.EEPROM__WRITE__ACK);
	}
	
	public Eeprom_write_ackMsg(byte[] packet) {
		setPacketData(packet);
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleEeprom_write_ack(this);
	}

	@Override
	public String toString(){
		String myString = "eeprom_write_ack:";
		return myString;
	}

}