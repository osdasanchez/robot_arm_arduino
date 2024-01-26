
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum InterruptPin {
	PIN_2_INT0((byte)2),
	PIN_3_INT1((byte)3);

	private final byte value;
	
	private InterruptPin(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, InterruptPin> map;
	
	static {
		map = new HashMap<Byte, InterruptPin>();
		map.put((byte)2, InterruptPin.PIN_2_INT0);
		map.put((byte)3, InterruptPin.PIN_3_INT1);
	}
	
	public static InterruptPin fromValue(byte b) {
		return map.get(b);
	}
	
}
