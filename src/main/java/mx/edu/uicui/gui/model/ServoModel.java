package mx.edu.uicui.gui.model;

import mx.edu.uicui.jarduino.Pin;

public class ServoModel {
    private Pin analogOutPin;
    private int angleDegrees;

    public Pin getAnalogOutPin() {
        return analogOutPin;
    }

    public void setAnalogOutPin(Pin analogOutPin) {
        this.analogOutPin = analogOutPin;
    }

    public int getAngleDegrees() {
        return angleDegrees;
    }

    public void setAngleDegrees(int angleDegrees) {
        this.angleDegrees = angleDegrees;
    }
}
