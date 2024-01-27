package mx.edu.uicui;

import lombok.extern.slf4j.Slf4j;
import mx.edu.uicui.app.RobotArmApp;
import mx.edu.uicui.gui.model.AngleModel;
import mx.edu.uicui.gui.model.CoordinateModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
       final RobotArmApp robotArmApp = new RobotArmApp();
        //System.out.println("Starting Robot Arm App...");

/*       double theta1 = 100 * Math.PI / 180;
        double theta2 = 95 * Math.PI / 180;

        System.out.println("theta1: " + theta1);
        System.out.println("theta2: " + theta2);

        double L1 = 20;
        double L2 = 17;

        double x = L1 * Math.cos(theta1) + L2 * Math.cos(theta1 + theta2);
        double y = L1 * Math.sin(theta1) + L2 * Math.sin(theta1 + theta2);

        System.out.println("x: " + x);

        System.out.println("y: " + y);

        x = -11.5;
        y = 8.5;

         //theta1  = Math.atan2(y,x);

         theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));

       // theta2 = Math.atan(Math.sqrt(1- Math.pow((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2),2)        ) / ((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2)));
        theta1 = Math.atan2(y,x) - Math.atan2((L2 * Math.sin(theta2)) , (L1 + L2 * Math.cos(theta2)));

        System.out.println("theta1: " + (theta1 * 180 / Math.PI ) );
        System.out.println("theta2: " + (theta2 * 180 / Math.PI) );*/



/*
        double L1 = 21;
        double L2 = 16.5;

        double x = -20;
        double y = 6;

        double theta1  = Math.atan(y/x);

        double theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));

        System.out.println("theta1: " + theta1 * 180 / Math.PI);
        System.out.println("theta2: " + theta2 * 180 / Math.PI);*/
/*
        double xAbsolut = -20;
        double yAbsolut = 17;
        double zAbsolut = 10;

        Map<Integer,CoordinateModel> corrdinatesMap = new HashMap<>();
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

        for (Map.Entry<Integer, CoordinateModel> entry : corrdinatesMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value  x : " + entry.getValue().getX() + " Value  y : " + entry.getValue().getY() + " Value  z : " + entry.getValue().getZ());
        }*/

    }
}