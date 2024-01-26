
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class AttachInterruptMsg extends JArduinoProtocolPacket {

	private InterruptPin interrupt;
	private InterruptTrigger mode;
	
	public AttachInterruptMsg(InterruptPin interrupt, InterruptTrigger mode) {
		setCommandID(JArduinoProtocol.ATTACH_INTERRUPT);
		setByteValue(interrupt.getValue());
		this.interrupt = interrupt;
		setByteValue(mode.getValue());
		this.mode = mode;
	}
	
	public AttachInterruptMsg(byte[] packet) {
		setPacketData(packet);
		interrupt = InterruptPin.fromValue(buffer.get());		
		mode = InterruptTrigger.fromValue(buffer.get());		
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleAttachInterrupt(this);
	}

	@Override
	public String toString(){
		String myString = "attachInterrupt:";
		myString += " [interrupt: "+interrupt+"]";
		myString += " [mode: "+mode+"]";
		return myString;
	}

	public InterruptPin getInterrupt() {
		return interrupt;
	}
	
	public InterruptTrigger getMode() {
		return mode;
	}
	
}