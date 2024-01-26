
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class ToneMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
	private short frequency;
	private short duration;
	
	public ToneMsg(DigitalPin pin, short frequency, short duration) {
		setCommandID(JArduinoProtocol.TONE);
		setByteValue(pin.getValue());
		this.pin = pin;
		setShortValue(frequency);
		this.frequency = frequency;
		setShortValue(duration);
		this.duration = duration;
	}
	
	public ToneMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());		
		frequency = buffer.getShort();
		duration = buffer.getShort();
		
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handleTone(this);
	}

	@Override
	public String toString(){
		String myString = "tone:";
		myString += " [pin: "+pin+"]";
		myString += " [frequency: "+frequency+"]";
		myString += " [duration: "+duration+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}
	
	public short getFrequency() {
		return frequency;
	}
	
	public short getDuration() {
		return duration;
	}
	
}