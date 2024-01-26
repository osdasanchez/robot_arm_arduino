
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class PingMsg extends JArduinoProtocolPacket {

	
	public PingMsg() {
		setCommandID(JArduinoProtocol.PING);
	}
	
	public PingMsg(byte[] packet) {
		setPacketData(packet);
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handlePing(this);
	}

	@Override
	public String toString(){
		String myString = "ping:";
		return myString;
	}

}