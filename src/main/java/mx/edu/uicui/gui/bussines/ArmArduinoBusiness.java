package mx.edu.uicui.gui.bussines;

import mx.edu.uicui.gui.model.AngleModel;
import mx.edu.uicui.gui.model.CoordinateModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmArduinoBusiness {

    private final ArduinoControl arduinoControl;
    private final LetterBusiness letterBusiness;

    public ArmArduinoBusiness(ArduinoControl arduinoControl, LetterBusiness letterBusiness) {
        this.arduinoControl = arduinoControl;
        this.letterBusiness = letterBusiness;
    }

    public String[] getPorts() {
        return this.arduinoControl.getPorts();
    }

    public void connect(String portName) {
        this.arduinoControl.connect(portName);
    }

    public void disconnect() {
        this.arduinoControl.disconnect();
    }

    public boolean isConnected() {
        return this.arduinoControl.isConnected();
    }

    public void send(String data) {
        //this.arduinoControl.send(data);



        char[] letters = data.toUpperCase().toCharArray();

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
            for(AngleModel angleModel : angleModels){
                //this.arduinoControl.send((int)angleModel.getThetha1() + " " + (int)angleModel.getThetha3() + " " + (int)angleModel.getThetha2() + " 80");
                this.arduinoControl.send(data);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            i++;
        }



    }


}
