package mx.edu.uicui.jarduino;

public class Analog extends JArduino {
    // These constants won't change.  They're used to give names
    // to the pins used:
    final Pin analogInPin = pA1;  // Analog input pin that the potentiometer is attached to
    final Pin analogOutPin3 = p3; // Analog output pin that the LED is attached to

    final Pin analogOutPin9 = p9;
    int sensorValue = 0;        // value read from the pot
    int outputValue = 0;        // value output to the PWM (analog out)

    public Analog(String port) {
        super(port);
    }

    @Override
    protected void setup() {
    }

    @Override
    protected void loop() throws InvalidPinTypeException {


        // read the analog in value:
        sensorValue =  90;//analogRead(analogInPin);
        // map it to the range of the analog out:
        outputValue = map(sensorValue, 0, 180, 0, 180);
        // change the analog out value:
        analogWrite(analogOutPin9, (byte) outputValue);
        //delay(1000);


      /*  // print the results to the serial monitor:
        System.out.print("sensor = ");
        System.out.print(sensorValue);
        System.out.print("\t output = ");
        System.out.println(outputValue);

        // wait 10 milliseconds before the next loop
        // for the analog-to-digital converter to settle
        // after the last reading:
        delay(10);*/

/*        for(int i = 0; i <= 180; i++){
            sensorValue = i;//analogRead(analogInPin);
            // map it to the range of the analog out:
            outputValue = map(sensorValue, 0, 180, 0, 180);
        	analogWrite(analogOutPin, (byte) outputValue);

            System.out.print("sensor = ");
            System.out.print(sensorValue);
            System.out.print("\t output = ");
            System.out.println(outputValue);
        	delay(20);
        }*/
        //delay(1000);

    }

/*    public static void main(String[] args) {

        String serialPort = "/dev/cu.usbmodem142301";

        JArduino arduino = new Analog(serialPort);
        arduino.runArduinoProcess();
    }*/
}
