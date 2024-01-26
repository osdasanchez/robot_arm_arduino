
package mx.edu.uicui.jarduino;

public abstract class JArduinoProtocolPacket extends FixedSizePacket {
	
	public JArduinoProtocolPacket() {
		super();
	}
	
	protected void setCommandID(byte cmd) {
		data[4] = cmd;
	}
	
	protected byte getCommandID(){
		return data[4];
	}
	
	public abstract void acceptHandler(JArduinoMessageHandler v);
	
	protected void setShortValue(Short v) {
		buffer.putShort(v);
	}

    protected void setIntValue(Integer v) {
        buffer.putInt(v);
    }
	
	protected void setByteValue(Byte v) {
		buffer.put(v);
	}
	
}