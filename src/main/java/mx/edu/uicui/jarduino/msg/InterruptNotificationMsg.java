
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class InterruptNotificationMsg extends JArduinoProtocolPacket {

	private InterruptPin interrupt;
	
	public InterruptNotificationMsg(InterruptPin interrupt) {
		setCommandID(JArduinoProtocol.INTERRUPT_NOTIFICATION);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
	}
	
	public InterruptNotificationMsg(byte[] packet) {
		setPacketData(packet);
		interrupt = InterruptPin.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleInterruptNotification(this);
	}

	@Override
	public String toString(){
		String myString = "interruptNotification:";
		myString += " [interrupt: "+interrupt+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
}