
package mx.edu.uicui.jarduino.observer;

public interface JArduinoClientSubject {
	void register(JArduinoClientObserver observer);
	void unregister(JArduinoClientObserver observer);
}
