
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum AnalogPin {
	A_0((byte)14),
	A_1((byte)15),
	A_2((byte)16),
	A_3((byte)17),
	A_4((byte)18),
	A_5((byte)19);

	private final byte value;
	
	private AnalogPin(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, AnalogPin> map;
	
	static {
		map = new HashMap<Byte, AnalogPin>();
		map.put((byte)14, AnalogPin.A_0);
		map.put((byte)15, AnalogPin.A_1);
		map.put((byte)16, AnalogPin.A_2);
		map.put((byte)17, AnalogPin.A_3);
		map.put((byte)18, AnalogPin.A_4);
		map.put((byte)19, AnalogPin.A_5);
	}
	
	public static AnalogPin fromValue(byte b) {
		return map.get(b);
	}
	
}
