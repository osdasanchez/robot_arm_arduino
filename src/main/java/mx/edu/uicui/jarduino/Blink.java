package mx.edu.uicui.jarduino;

public class Blink extends JArduino{

    public Blink(String port) {
        super(port);
    }
    @Override
    protected void setup() throws InvalidPinTypeException {

        // initialize the digital pin as an output.
        // Pin 13 has an LED connected on most Arduino boards:
        pinMode(DigitalPin.PIN_13, PinMode.OUTPUT);
    }

    @Override
    protected void loop() throws InvalidPinTypeException {

        // set the LED on
        digitalWrite(DigitalPin.PIN_13, DigitalState.HIGH);
        delay(1000); // wait for a second
        // set the LED off
        digitalWrite(DigitalPin.PIN_13, DigitalState.LOW);
        delay(1000); // wait for a second
    }

/*    public static void main(String[] args) {
        JArduino arduino = new Blink("/dev/cu.usbmodem142301");
        arduino.runArduinoProcess();
    }*/
}
