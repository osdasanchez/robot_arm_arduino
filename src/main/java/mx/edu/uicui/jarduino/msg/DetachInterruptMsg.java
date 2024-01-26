
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class DetachInterruptMsg extends JArduinoProtocolPacket {

	private InterruptPin interrupt;
	
	public DetachInterruptMsg(InterruptPin interrupt) {
		setCommandID(JArduinoProtocol.DETACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
	}
	
	public DetachInterruptMsg(byte[] packet) {
		setPacketData(packet);
		interrupt = InterruptPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleDetachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "detachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
}