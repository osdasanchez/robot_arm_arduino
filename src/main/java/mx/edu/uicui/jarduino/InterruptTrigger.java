
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum InterruptTrigger {
	CHANGE((byte)1),
	RISING((byte)3),
	FALLING((byte)2),
	LOW((byte)0);

	private final byte value;
	
	private InterruptTrigger(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, InterruptTrigger> map;
	
	static {
		map = new HashMap<Byte, InterruptTrigger>();
		map.put((byte)1, InterruptTrigger.CHANGE);
		map.put((byte)3, InterruptTrigger.RISING);
		map.put((byte)2, InterruptTrigger.FALLING);
		map.put((byte)0, InterruptTrigger.LOW);
	}
	
	public static InterruptTrigger fromValue(byte b) {
		return map.get(b);
	}
	
}
