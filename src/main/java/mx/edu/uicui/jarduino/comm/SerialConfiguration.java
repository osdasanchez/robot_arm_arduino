

package mx.edu.uicui.jarduino.comm;

import mx.edu.uicui.jarduino.ProtocolConfiguration;

public class SerialConfiguration extends ProtocolConfiguration {
	private int baudRate;

	public SerialConfiguration(int baudRate) {
		super();
		this.baudRate = baudRate;
	}

	public int getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}
	
}
