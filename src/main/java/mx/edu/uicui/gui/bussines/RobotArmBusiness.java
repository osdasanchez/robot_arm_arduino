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
    private Arm arm;

    public RobotArmBusiness(Serial4JArduino serial4JArduino, LetterBusiness letterBusiness) {
        this.serial4JArduino = serial4JArduino;
        this.letterBusiness = letterBusiness;
    }

    public String[] getPorts() {

        return this.serial4JArduino.getPortList();

    }

    public void connect(String port) {
        this.serial4JArduino.connect(port);
        this.arm = new Arm(this.serial4JArduino);
        this.arm.runArduinoProcess();
    }

    public void sendData(String word) {

        char[] letters = word.toUpperCase().toCharArray();

        double xAbsolut = -26;
        double yAbsolut = 20;
        double zAbsolut = 8;

        Map<Integer, CoordinateModel> corrdinatesMap = new HashMap<>();
        int key = 1;
        for (int i = 1; i <= 5; i++) {
            double x = xAbsolut;
            for (int j = 1; j <= 8; j++) {
                CoordinateModel coordinateModel = new CoordinateModel();

                coordinateModel.setX(x);
                coordinateModel.setY(yAbsolut);
                coordinateModel.setZ(zAbsolut);
                if(j >= 5 && j<=8){
                    coordinateModel.setZ(9);
                }
                corrdinatesMap.put(key, coordinateModel);
                key++;
                x = x + 4;

            }
            yAbsolut = yAbsolut - 4;

        }


        int i = 1;
        for (char letter : letters) {

            List<AngleModel> angleModels =
                    letterBusiness.calculateAngles(letter, corrdinatesMap.get(i).getX(), corrdinatesMap.get(i).getY(), corrdinatesMap.get(i).getZ());
            for (AngleModel angleModel : angleModels) {
                //this.arduinoControl.send((int)angleModel.getThetha1() + " " + (int)angleModel.getThetha3() + " " + (int)angleModel.getThetha2() + " 80");
                this.arm.sendAnalogData((int) angleModel.getThetha1(), (int) angleModel.getThetha2(), (int) angleModel.getThetha3());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

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

    public void sendData() {
        List<CoordinateModel> coordinateModels = new ArrayList<>();

        //R
        coordinateModels.add(getCoordinateModel(-25.5, 18, 11));
        coordinateModels.add(getCoordinateModel(-25.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 19.5, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 21, 10));
        coordinateModels.add(getCoordinateModel(-25, 21, 10));
        coordinateModels.add(getCoordinateModel(-24, 21, 10));
        coordinateModels.add(getCoordinateModel(-23, 21, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 21, 10));
        coordinateModels.add(getCoordinateModel(-23.5, 20, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 19.5, 10));
        coordinateModels.add(getCoordinateModel(-24, 18.5, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 18, 11));

        /*//O
        coordinateModels.add(getCoordinateModel(-19, 18, 11));
        coordinateModels.add(getCoordinateModel(-19, 18, 10));
        coordinateModels.add(getCoordinateModel(-22, 18, 10));
        coordinateModels.add(getCoordinateModel(-22, 21, 10));
        coordinateModels.add(getCoordinateModel(-19, 21, 10));
        coordinateModels.add(getCoordinateModel(-19, 18, 10));
        coordinateModels.add(getCoordinateModel(-19, 18, 11));

        //B
        coordinateModels.add(getCoordinateModel(-15.5, 18, 11));
        coordinateModels.add(getCoordinateModel(-15.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 21, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 21, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 19.5, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 18, 11));


        //O
        coordinateModels.add(getCoordinateModel(-11.9, 18, 11));
        coordinateModels.add(getCoordinateModel(-11.9, 18, 10));
        coordinateModels.add(getCoordinateModel(-15, 18, 10));
        coordinateModels.add(getCoordinateModel(-15, 21, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 21, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 18, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 18, 11));

        //T
        coordinateModels.add(getCoordinateModel(-10, 18, 11));
        coordinateModels.add(getCoordinateModel(-10, 18, 10));
        coordinateModels.add(getCoordinateModel(-10, 21, 10));
        coordinateModels.add(getCoordinateModel(-10, 21, 11));
        coordinateModels.add(getCoordinateModel(-11.3, 21, 11));
        coordinateModels.add(getCoordinateModel(-11.3, 21, 10));
        coordinateModels.add(getCoordinateModel(-8.3, 21, 10));
        coordinateModels.add(getCoordinateModel(-8.3, 21, 11));

        //I
        coordinateModels.add(getCoordinateModel(-7, 18, 11));
        coordinateModels.add(getCoordinateModel(-7, 18, 10));
        coordinateModels.add(getCoordinateModel(-7, 21, 10));
        coordinateModels.add(getCoordinateModel(-7, 21, 11));

        //C
        coordinateModels.add(getCoordinateModel(-3, 18, 11));
        coordinateModels.add(getCoordinateModel(-3, 18, 10));
        coordinateModels.add(getCoordinateModel(-6, 18, 10));
        coordinateModels.add(getCoordinateModel(-6, 21, 10));
        coordinateModels.add(getCoordinateModel(-3, 21, 10));
        coordinateModels.add(getCoordinateModel(-3, 21, 11));

        //A
        coordinateModels.add(getCoordinateModel(-2.5, 18, 11));
        coordinateModels.add(getCoordinateModel(-2.5, 18, 10));
        coordinateModels.add(getCoordinateModel(-1.3, 21, 10));
        coordinateModels.add(getCoordinateModel(0, 18, 10));
        coordinateModels.add(getCoordinateModel(0, 18, 11));
        coordinateModels.add(getCoordinateModel(-2, 19.5, 11));
        coordinateModels.add(getCoordinateModel(-2, 19.5, 10));
        coordinateModels.add(getCoordinateModel(0, 19.5, 10));
        coordinateModels.add(getCoordinateModel(0, 19.5, 11));


        //I
        coordinateModels.add(getCoordinateModel(-24, 14.5, 11));
        coordinateModels.add(getCoordinateModel(-24, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-24, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-24, 17.5, 11));

        //T
        coordinateModels.add(getCoordinateModel(-20.5, 14.5, 11));
        coordinateModels.add(getCoordinateModel(-20.5, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 17.5, 11));
        coordinateModels.add(getCoordinateModel(-22, 17.5, 11));
        coordinateModels.add(getCoordinateModel(-22, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-19, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-19, 17.5, 11));

        //S
        coordinateModels.add(getCoordinateModel(-18.5, 14.5, 11));
        coordinateModels.add(getCoordinateModel(-18.5, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 16, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 16, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 17.5, 11));

        //E
        coordinateModels.add(getCoordinateModel(-11.9, 14.5, 11));
        coordinateModels.add(getCoordinateModel(-11.9, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-15, 14.5, 10));
        coordinateModels.add(getCoordinateModel(-15, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 17.5, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 17.5, 11));
        coordinateModels.add(getCoordinateModel(-15, 16, 11));
        coordinateModels.add(getCoordinateModel(-15, 16, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 16, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 16, 11));

        //U
        coordinateModels.add(getCoordinateModel(-25.5, 14, 11));
        coordinateModels.add(getCoordinateModel(-25.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-23.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-23.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-23.5, 14, 11));

        //N
        coordinateModels.add(getCoordinateModel(-22.5, 11, 11));
        coordinateModels.add(getCoordinateModel(-22.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 14, 11));

        //I
        coordinateModels.add(getCoordinateModel(-19, 11, 11));
        coordinateModels.add(getCoordinateModel(-19, 11, 10));
        coordinateModels.add(getCoordinateModel(-19, 14, 10));
        coordinateModels.add(getCoordinateModel(-19, 14, 11));

        //V
        coordinateModels.add(getCoordinateModel(-18.5, 14, 11));
        coordinateModels.add(getCoordinateModel(-18.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-16, 14, 10));
        coordinateModels.add(getCoordinateModel(-16, 14, 11));

        //E
        coordinateModels.add(getCoordinateModel(-13.5, 11, 11));
        coordinateModels.add(getCoordinateModel(-13.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-15.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-13.5, 14, 10));
        coordinateModels.add(getCoordinateModel(-13.5, 14, 11));
        coordinateModels.add(getCoordinateModel(-15.5, 12.5, 11));
        coordinateModels.add(getCoordinateModel(-15.5, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-13.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-13.5, 11, 11));

        //R
        coordinateModels.add(getCoordinateModel(-11.9, 11, 11));
        coordinateModels.add(getCoordinateModel(-11.9, 11, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 14, 10));
        coordinateModels.add(getCoordinateModel(-10, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-11.9, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-10, 11, 10));
        coordinateModels.add(getCoordinateModel(-10, 11, 11));

        //S
        coordinateModels.add(getCoordinateModel(-9, 11, 11));
        coordinateModels.add(getCoordinateModel(-9, 11, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 11, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-9, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-9, 14, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 14, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 14, 11));

        //I
        coordinateModels.add(getCoordinateModel(-7, 11, 11));
        coordinateModels.add(getCoordinateModel(-7, 11, 10));
        coordinateModels.add(getCoordinateModel(-7, 14, 10));
        coordinateModels.add(getCoordinateModel(-7, 14, 11));

        //D
        coordinateModels.add(getCoordinateModel(-6, 11, 11));
        coordinateModels.add(getCoordinateModel(-6, 11, 10));
        coordinateModels.add(getCoordinateModel(-6, 14, 10));
        coordinateModels.add(getCoordinateModel(-4, 11.5, 10));
        coordinateModels.add(getCoordinateModel(-6, 11, 10));
        coordinateModels.add(getCoordinateModel(-6, 11, 11));

        //A
        coordinateModels.add(getCoordinateModel(-4, 11, 11));
        coordinateModels.add(getCoordinateModel(-4, 11, 10));
        coordinateModels.add(getCoordinateModel(-3, 14, 10));
        coordinateModels.add(getCoordinateModel(-1.5, 11, 10));
        coordinateModels.add(getCoordinateModel(-1.5, 11, 11));
        coordinateModels.add(getCoordinateModel(-3.5, 12.5, 11));
        coordinateModels.add(getCoordinateModel(-3.5, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-2.5, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-2.5, 12.5, 11));

        //D
        coordinateModels.add(getCoordinateModel(-1.3, 11, 11));
        coordinateModels.add(getCoordinateModel(-1.3, 11, 10));
        coordinateModels.add(getCoordinateModel(-1.3, 14, 10));
        coordinateModels.add(getCoordinateModel(0, 12.5, 10));
        coordinateModels.add(getCoordinateModel(-1.3, 11, 10));
        coordinateModels.add(getCoordinateModel(-1.3, 11, 11));

        //I
        coordinateModels.add(getCoordinateModel(-24, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-24, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-24, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-24, 10.4, 11));

        //X
        coordinateModels.add(getCoordinateModel(-22.5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-22.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-20.5, 10.4, 11));
        coordinateModels.add(getCoordinateModel(-20.5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-20.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 10.4, 11));

        //T
        coordinateModels.add(getCoordinateModel(-19, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-19, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-19, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-19.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-18.5, 10.4, 11));

        //L
        coordinateModels.add(getCoordinateModel(-16.5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-16.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 10.4, 11));

        //A
        coordinateModels.add(getCoordinateModel(-15.5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-15.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-13.5, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-12, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-12, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-15, 9, 11));
        coordinateModels.add(getCoordinateModel(-15, 9, 10));
        coordinateModels.add(getCoordinateModel(-12, 9, 10));
        coordinateModels.add(getCoordinateModel(-12, 9, 11));

        //H
        coordinateModels.add(getCoordinateModel(-11.3, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-11.3, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-11.3, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-11.3, 10.4, 11));
        coordinateModels.add(getCoordinateModel(-10, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-10, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-10, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-10, 10.4, 11));
        coordinateModels.add(getCoordinateModel(-11.3, 9, 11));
        coordinateModels.add(getCoordinateModel(-11.3, 9, 10));
        coordinateModels.add(getCoordinateModel(-10, 9, 10));
        coordinateModels.add(getCoordinateModel(-10, 9, 11));

        //U
        coordinateModels.add(getCoordinateModel(-9, 10.4, 11));
        coordinateModels.add(getCoordinateModel(-9, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-9, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-7.8, 10.4, 11));

        //A
        coordinateModels.add(getCoordinateModel(-7, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-7, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-6, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-6.8, 9, 11));
        coordinateModels.add(getCoordinateModel(-6.8, 9, 10));
        coordinateModels.add(getCoordinateModel(-5.8, 9, 10));
        coordinateModels.add(getCoordinateModel(-5.8, 9, 11));

        //C
        coordinateModels.add(getCoordinateModel(-2, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-2, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-4, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-4, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-2, 10.4, 10));
        coordinateModels.add(getCoordinateModel(-2, 10.4, 11));

        //A
        coordinateModels.add(getCoordinateModel(-1.5, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-1.5, 7.5, 10));
        coordinateModels.add(getCoordinateModel(-1, 10.4, 10));
        coordinateModels.add(getCoordinateModel(0, 7.5, 10));
        coordinateModels.add(getCoordinateModel(0, 7.5, 11));
        coordinateModels.add(getCoordinateModel(-1, 9, 11));
        coordinateModels.add(getCoordinateModel(-1, 9, 10));
        coordinateModels.add(getCoordinateModel(0.5, 9, 10));
        coordinateModels.add(getCoordinateModel(0.5, 9, 11));

        //C
        coordinateModels.add(getCoordinateModel(-22.5, 3.8, 11));
        coordinateModels.add(getCoordinateModel(-22.5, 3.8, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 3.8, 10));
        coordinateModels.add(getCoordinateModel(-25.5, 7, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 7, 10));
        coordinateModels.add(getCoordinateModel(-22.5, 7, 11));

        //U
        coordinateModels.add(getCoordinateModel(-22, 7, 11));
        coordinateModels.add(getCoordinateModel(-22, 7, 10));
        coordinateModels.add(getCoordinateModel(-22, 3.8, 10));
        coordinateModels.add(getCoordinateModel(-19, 3.8, 10));
        coordinateModels.add(getCoordinateModel(-19, 7, 10));
        coordinateModels.add(getCoordinateModel(-19, 7, 11));

        //I
        coordinateModels.add(getCoordinateModel(-17.5, 3.8, 11));
        coordinateModels.add(getCoordinateModel(-17.5, 3.8, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 7, 10));
        coordinateModels.add(getCoordinateModel(-17.5, 7, 11));
        */





        for (CoordinateModel coordinate : coordinateModels) {

            AngleModel angleModel = letterBusiness.calculateInverseKinematics2(coordinate.getX(), coordinate.getY());
            if (coordinate.getZ() == 10) {
                angleModel.setThetha3(85);
            }
            if (coordinate.getZ() == 11) {
                angleModel.setThetha3(100);
            }

            this.arm.sendAnalogData((int) angleModel.getThetha1(), (int) angleModel.getThetha2(), (int) angleModel.getThetha3());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private CoordinateModel getCoordinateModel(double x, double y, double z) {
        CoordinateModel coordinateModel = new CoordinateModel();
        coordinateModel.setX(x);
        coordinateModel.setY(y);
        coordinateModel.setZ(z);
        return coordinateModel;
    }

    public void disconnect() {
        this.arm.stopArduinoProcess();
        this.serial4JArduino.disconnect();
    }
}
