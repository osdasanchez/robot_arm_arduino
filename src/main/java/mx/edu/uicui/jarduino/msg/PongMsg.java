
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class PongMsg extends JArduinoProtocolPacket {

	
	public PongMsg() {
		setCommandID(JArduinoProtocol.PONG);
	}
	
	public PongMsg(byte[] packet) {
		setPacketData(packet);
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handlePong(this);
	}

	@Override
	public String toString(){
		String myString = "pong:";
		return myString;
	}

}