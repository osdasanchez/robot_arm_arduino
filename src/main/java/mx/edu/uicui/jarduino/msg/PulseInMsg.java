
package mx.edu.uicui.jarduino.msg;

import mx.edu.uicui.jarduino.*;

public class PulseInMsg extends JArduinoProtocolPacket {

	private DigitalPin pin;
    private DigitalState state;

	public PulseInMsg(DigitalPin pin, DigitalState state) {
		setCommandID(JArduinoProtocol.PULSE_IN);
		setByteValue(pin.getValue());
		this.pin = pin;
        setByteValue(state.getValue());
        this.state = state;
	}

	public PulseInMsg(byte[] packet) {
		setPacketData(packet);
		pin = DigitalPin.fromValue(buffer.get());
		state = DigitalState.fromValue(buffer.get());
	}
	
	@Override
	public void acceptHandler(JArduinoMessageHandler v) {
		v.handlePulseIn(this);
	}

	@Override
	public String toString(){
		String myString = "analogRead:";
		myString += " [pin: "+pin+"]";
		return myString;
	}

	public DigitalPin getPin() {
		return pin;
	}

    public DigitalState getState() {
        return state;
    }
	
}