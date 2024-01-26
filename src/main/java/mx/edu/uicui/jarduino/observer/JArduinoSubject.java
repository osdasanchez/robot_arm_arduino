
package mx.edu.uicui.jarduino.observer;

public interface JArduinoSubject {
	void register(JArduinoObserver observer);
	void unregister(JArduinoObserver observer);
}
