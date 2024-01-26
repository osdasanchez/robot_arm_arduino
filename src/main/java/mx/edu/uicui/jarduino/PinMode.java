
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum PinMode {
	INPUT((byte)0),
	OUTPUT((byte)1);

	private final byte value;
	
	private PinMode(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, PinMode> map;
	
	static {
		map = new HashMap<Byte, PinMode>();
		map.put((byte)0, PinMode.INPUT);
		map.put((byte)1, PinMode.OUTPUT);
	}
	
	public static PinMode fromValue(byte b) {
		return map.get(b);
	}
	
}
