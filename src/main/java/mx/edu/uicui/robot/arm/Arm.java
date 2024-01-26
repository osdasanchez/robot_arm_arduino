package mx.edu.uicui.robot.arm;

import mx.edu.uicui.gui.model.AngleModel;
import mx.edu.uicui.gui.model.ServoModel;
import mx.edu.uicui.jarduino.InvalidPinTypeException;
import mx.edu.uicui.jarduino.JArduino;
import mx.edu.uicui.jarduino.Pin;
import mx.edu.uicui.jarduino.comm.Serial4JArduino;

import java.util.List;

public class Arm extends JArduino {

    private final Pin analogOutPin3 = p3;

    private final Pin analogOutPin5 = p5;

    private final Pin analogOutPin6 = p6;

    private final Pin analogOutPin9 = p9;

    int servo1StartAngle = 90;
    int servo1EndAngle = 90;

    int servo2StartAngle = 90;
    int servo2EndAngle = 90;

    int servo3StartAngle = 90;
    int servo3EndAngle = 90;

    int servo4startAngle = 80;
    int servo4EndAngle = 90;

    // value output to the PWM (analog out)
    int outputServo1 = 0;
    int outputServo2 = 0;
    int outputServo3 = 0;
    int outputServo4 = 0;

    boolean servo1MovingForward = false;
    boolean servo2MovingForward = false;
    boolean servo3MovingForward = false;
    boolean servo4MovingForward = false;

    boolean servo1MovingBackward = false;
    boolean servo2MovingBackward = false;
    boolean servo3MovingBackward = false;
    boolean servo4MovingBackward = false;


    // variables to store the servo angles in degrees for writing letters
    List<AngleModel> angleModels;
    boolean isWritingEnable = false;

    public Arm(Serial4JArduino serial) {
        super(serial);
    }

    @Override
    protected void setup() throws InvalidPinTypeException {

    }

    @Override
    protected void loop() throws InvalidPinTypeException {
        // read the analog in value:
        // sensorValue =  90;//analogRead(analogInPin);
        // map it to the range of the analog out:
        // outputServo1 = map(servo1Angle, 0, 180, 0, 180);
        // change the analog out value:
        // System.out.println("Servo 1: " + outputServo1);
        // analogWrite(analogOutPin3, (byte) outputServo1);
        // delay(1000);

        //outputServo2 = i;


        if (isWritingEnable) {
            for (AngleModel angleModel : angleModels) {

                isWritingEnable = true;
                servo1EndAngle = (int) angleModel.getThetha1();
                servo2EndAngle = (int) angleModel.getThetha3();
                servo3EndAngle = (int) angleModel.getThetha2();

                System.out.println("Servo 1: " + servo1EndAngle);
                System.out.println("Servo 2: " + servo2EndAngle);
                System.out.println("Servo 3: " + servo3EndAngle);


                if (isMovingForward(servo1StartAngle, servo1EndAngle)) {
                    System.out.println("Servo 1: moving forward ");
                    //servo1StartAngle = servo1EndAngle;
                } else if (isMovingBackward(servo1StartAngle, servo1EndAngle)) {
                    System.out.println("Servo 1: moving backward ");
                    //servo1StartAngle = servo1EndAngle;
                }

                if (isMovingForward(servo2StartAngle, servo2EndAngle)) {
                    System.out.println("Servo 2: moving forward ");
                    //servo2StartAngle = servo2EndAngle;
                } else if (isMovingBackward(servo2StartAngle, servo2EndAngle)) {
                    System.out.println("Servo 2: moving backward ");
                    //servo2StartAngle = servo2EndAngle;
                }

                if (isMovingForward(servo3StartAngle, servo3EndAngle)) {
                    System.out.println("Servo 3: moving forward ");
                    //servo3StartAngle = servo3EndAngle;

                } else if (isMovingBackward(servo3StartAngle, servo3EndAngle)) {
                    System.out.println("Servo 3: moving backward ");
                    //servo3StartAngle = servo3EndAngle;

                }
                analogWrite(analogOutPin3, (byte) servo1EndAngle);
                analogWrite(analogOutPin5, (byte) servo2EndAngle);
                analogWrite(analogOutPin6, (byte) servo3EndAngle);
                analogWrite(analogOutPin9, (byte) servo4EndAngle);
                delay(1000);

            }
            //isWritingEnable = false;

        } else {
            analogWrite(analogOutPin3, (byte) servo1StartAngle);
            analogWrite(analogOutPin5, (byte) servo2StartAngle);
            analogWrite(analogOutPin6, (byte) servo3StartAngle);
            analogWrite(analogOutPin9, (byte) servo4startAngle);
        }



        if (servo1MovingForward) {
            for (int i = servo1StartAngle; i <= servo1EndAngle; i++) {
                outputServo1 = i;
                System.out.println("Servo 1: " + outputServo1);
                analogWrite(analogOutPin3, (byte) outputServo1);
                delay(100);
                // analogWrite(analogOutPin5, (byte) outputServo1);
                // delay(100);

            }
            servo1MovingForward = false;
            servo1StartAngle = servo1EndAngle;
            // servo2StartAngle = servo1EndAngle;
        }

        if (servo1MovingBackward) {
            for (int i = servo1StartAngle; i >= servo1EndAngle; i--) {
                outputServo1 = i;
                System.out.println("Servo 1: " + outputServo1);
                analogWrite(analogOutPin3, (byte) outputServo1);
                delay(100);
                //analogWrite(analogOutPin5, (byte) outputServo1);
                //delay(100);

            }
            servo1MovingBackward = false;
            //servo1StartAngle = servo1EndAngle;
            //servo2StartAngle = servo1EndAngle;
        }

        if (servo2MovingForward) {
            for (int i = servo2StartAngle; i <= servo2EndAngle; i++) {
                outputServo2 = i;
                System.out.println("Servo 2: " + outputServo2);
                analogWrite(analogOutPin5, (byte) outputServo2);
                delay(100);
            }
            servo2MovingForward = false;
            servo2StartAngle = servo2EndAngle;
        }

        if (servo2MovingBackward) {
            for (int i = servo2StartAngle; i >= servo2EndAngle; i--) {
                System.out.println("Servo 2: " + outputServo2);
                outputServo2 = i;
                analogWrite(analogOutPin5, (byte) outputServo2);
                delay(100);
            }
            servo2MovingBackward = false;
            servo2StartAngle = servo2EndAngle;
        }

        if (servo3MovingForward) {
            for (int i = servo3StartAngle; i <= servo3EndAngle; i++) {
                System.out.println("Servo 3: " + outputServo3);
                outputServo3 = i;
                analogWrite(analogOutPin6, (byte) outputServo3);
                delay(100);
            }
            servo3MovingForward = false;
            servo3StartAngle = servo3EndAngle;
        }

        if (servo3MovingBackward) {
            for (int i = servo3StartAngle; i >= servo3EndAngle; i--) {
                System.out.println();
                outputServo3 = i;
                analogWrite(analogOutPin6, (byte) outputServo3);
                delay(100);
            }
            servo3MovingBackward = false;
            servo3StartAngle = servo3EndAngle;
        }

        if (servo4MovingForward) {
            for (int i = servo4startAngle; i <= servo4EndAngle; i++) {
                outputServo4 = i;
                analogWrite(analogOutPin9, (byte) outputServo4);
                delay(100);
            }
            servo4MovingForward = false;
            servo4startAngle = servo4EndAngle;
        }

        if (servo4MovingBackward) {
            for (int i = servo4startAngle; i >= servo4EndAngle; i--) {
                outputServo4 = i;
                analogWrite(analogOutPin9, (byte) outputServo4);
                delay(100);
            }
            servo4MovingBackward = false;
            servo4startAngle = servo4EndAngle;
        }


    }

    public void sendAnalogData(int pin, int value) {
        //this.servo3Angle = value;

    /*    for (int i = 90; i <= value; i++) {
            this.servo1Angle = i;
        }*/

    }

    public void sendAnalogData(List<AngleModel> angleModels) {
        this.angleModels = angleModels;
        isWritingEnable = true;

    }

    public void sendAnalogData(List<ServoModel> servoModels, boolean isMovingLinear) {
        for (ServoModel servoModel : servoModels) {
            System.out.println("Servo: " + servoModel.getAnalogOutPin() + " Angle: " + servoModel.getAngleDegrees());
            switch (servoModel.getAnalogOutPin()) {
                case PIN_3: // servomotor 1
                    servo1EndAngle = servoModel.getAngleDegrees();
                    if (isMovingForward(servo1StartAngle, servo1EndAngle)) {
                        servo1MovingForward = true;
                        System.out.println("Servo 1: moving forward ");
                    } else if (isMovingBackward(servo1StartAngle, servo1EndAngle)) {
                        servo1MovingBackward = true;
                        System.out.println("Servo 1: moving backward ");
                    }

                    break;
                case PIN_5: // servomotor 2
                    servo2EndAngle = servoModel.getAngleDegrees();
                    if (isMovingForward(servo2StartAngle, servo2EndAngle)) {
                        servo2MovingForward = true;
                    } else if (isMovingBackward(servo2StartAngle, servo2EndAngle)) {
                        servo2MovingBackward = true;
                    }

                    break;
                case PIN_6: // servomotor 3
                    servo3EndAngle = servoModel.getAngleDegrees();
                    if (isMovingForward(servo3StartAngle, servo3EndAngle)) {
                        servo3MovingForward = true;
                    } else if (isMovingBackward(servo3StartAngle, servo3EndAngle)) {
                        servo3MovingBackward = true;
                    }

                    break;
                case PIN_9: // servomotor 4
                    servo4EndAngle = servoModel.getAngleDegrees();
                    if (isMovingForward(servo4startAngle, servo4EndAngle)) {
                        servo4MovingForward = true;
                    } else if (isMovingBackward(servo4startAngle, servo4EndAngle)) {
                        servo4MovingBackward = true;
                    }

                    break;
            }
        }
    }


    private boolean isMovingForward(int startAngle, int endAngle) {
        boolean movingForward = false;
        if (endAngle >= 0 && endAngle <= 180) {
            if (startAngle < endAngle) {
                movingForward = true;
            }
        }
        return movingForward;
    }

    private boolean isMovingBackward(int startAngle, int endAngle) {
        boolean movingBackward = false;
        if (endAngle >= 0 && endAngle <= 180) {
            if (startAngle > endAngle) {
                movingBackward = true;
            }
        }
        return movingBackward;
    }

}
