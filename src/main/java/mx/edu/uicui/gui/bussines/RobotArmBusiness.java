package mx.edu.uicui.gui.bussines;

import mx.edu.uicui.gui.model.AngleModel;
import mx.edu.uicui.gui.model.CoordinateModel;
import mx.edu.uicui.gui.model.ServoModel;
import mx.edu.uicui.jarduino.Pin;
import mx.edu.uicui.jarduino.comm.Serial4JArduino;
import mx.edu.uicui.robot.arm.Arm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotArmBusiness {
    private final Serial4JArduino serial4JArduino;

    private final LetterBusiness letterBusiness;
    private  Arm arm;

    public RobotArmBusiness(Serial4JArduino serial4JArduino, LetterBusiness letterBusiness) {
        this.serial4JArduino = serial4JArduino;
        this.letterBusiness = letterBusiness;
    }

    public String [] getPorts() {

        return this.serial4JArduino.getPortList();

    }

    public void connect(String port) {
        this.serial4JArduino.connect(port);
        this.arm = new Arm(this.serial4JArduino);
        this.arm.runArduinoProcess();
    }

    public void sendData(String word) {

        char[] letters = word.toUpperCase().toCharArray();

        double xAbsolut = -20;
        double yAbsolut = 17;
        double zAbsolut = 10;

        Map<Integer, CoordinateModel> corrdinatesMap = new HashMap<>();
        int key = 1;
        for(int i = 1 ; i<= 5 ; i++){
            double x = xAbsolut;
            for (int j = 1; j <= 8; j++) {
                CoordinateModel coordinateModel = new CoordinateModel();

                coordinateModel.setX(x);
                coordinateModel.setY(yAbsolut);
                coordinateModel.setZ(zAbsolut);
                corrdinatesMap.put(key,coordinateModel);
                key++;
                x = x + 2.5;

            }
            yAbsolut = yAbsolut - 2.5;

        }


        int i = 1;
        for (char letter : letters) {
            List<AngleModel> angleModels =
                    letterBusiness.calculateAngles(letter, corrdinatesMap.get(i).getX(), corrdinatesMap.get(i).getY());
            this.arm.sendAnalogData(angleModels);
            i++;
        }


/*        List<ServoModel> servoModels = new ArrayList<>();

        ServoModel servoModel1 = new ServoModel();
        servoModel1.setAnalogOutPin(Pin.PIN_3);
        servoModel1.setAngleDegrees(Integer.parseInt(word));

        servoModels.add(servoModel1);

        this.arm.sendAnalogData(servoModels);*/

       // this.arm.sendAnalogData(0, Integer.parseInt(word));

    }

    public void disconnect() {
        this.arm.stopArduinoProcess();
        this.serial4JArduino.disconnect();
    }
}
