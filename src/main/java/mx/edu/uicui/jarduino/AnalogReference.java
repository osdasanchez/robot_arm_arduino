
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum AnalogReference {
	DEFAULT((byte)1),
	INTERNAL((byte)3),
	EXTERNAL((byte)0);

	private final byte value;
	
	private AnalogReference(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, AnalogReference> map;
	
	static {
		map = new HashMap<Byte, AnalogReference>();
		map.put((byte)1, AnalogReference.DEFAULT);
		map.put((byte)3, AnalogReference.INTERNAL);
		map.put((byte)0, AnalogReference.EXTERNAL);
	}
	
	public static AnalogReference fromValue(byte b) {
		return map.get(b);
	}
	
}
