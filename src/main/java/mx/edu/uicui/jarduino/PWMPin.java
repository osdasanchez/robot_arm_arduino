
package mx.edu.uicui.jarduino;

import java.util.HashMap;
import java.util.Map;

public enum PWMPin {
	PWM_PIN_3((byte)3),
	PWM_PIN_5((byte)5),
	PWM_PIN_6((byte)6),
	PWM_PIN_9((byte)9),
	PWM_PIN_10((byte)10),
	PWM_PIN_11((byte)11);

	private final byte value;
	
	private PWMPin(byte value){
		this.value = value;
	}
	
	public byte getValue(){
		return value;
	}
	
	private static final Map<Byte, PWMPin> map;
	
	static {
		map = new HashMap<Byte, PWMPin>();
		map.put((byte)3, PWMPin.PWM_PIN_3);
		map.put((byte)5, PWMPin.PWM_PIN_5);
		map.put((byte)6, PWMPin.PWM_PIN_6);
		map.put((byte)9, PWMPin.PWM_PIN_9);
		map.put((byte)10, PWMPin.PWM_PIN_10);
		map.put((byte)11, PWMPin.PWM_PIN_11);
	}
	
	public static PWMPin fromValue(byte b) {
		return map.get(b);
	}
	
}
