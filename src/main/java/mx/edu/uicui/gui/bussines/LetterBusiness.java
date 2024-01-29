package mx.edu.uicui.gui.bussines;

import mx.edu.uicui.gui.model.AngleModel;
import mx.edu.uicui.gui.model.CoordinateModel;
import mx.edu.uicui.robot.arm.Arm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterBusiness {


    public void processWord(String word) {

        char[] letters = word.toUpperCase().toCharArray();
        processLetter(letters);


    }

    private void processLetter(char[] letters) {

        double xAbsolut = -20;
        double yAbsolut = 17;
        double zAbsolut = 10;

        Map<Integer, CoordinateModel> corrdinatesMap = new HashMap<>();
        int key = 1;
        for (int i = 1; i <= 5; i++) {
            double x = xAbsolut;
            for (int j = 1; j <= 8; j++) {
                CoordinateModel coordinateModel = new CoordinateModel();

                coordinateModel.setX(x);
                coordinateModel.setY(yAbsolut);
                coordinateModel.setZ(zAbsolut);
                corrdinatesMap.put(key, coordinateModel);
                key++;
                x = x + 2.5;

            }
            yAbsolut = yAbsolut - 2.5;

        }


        int i = 1;
        for (char letter : letters) {
            List<AngleModel> angleModels =
                    calculateAngles(letter, corrdinatesMap.get(i).getX(), corrdinatesMap.get(i).getY(), 0);
            i++;
        }

    }

    public List<AngleModel> calculateAngles(char letter, double xAbsolut, double yAbsolut, double zAbsolut) {
        List<AngleModel> angleModels = new ArrayList<>();
        List<CoordinateModel> coordinateModels = new ArrayList<>();

        switch (letter) {
            case 'A':
                System.out.println("A");
                coordinateModels.add(getCoordinateModel(1.5, 0, 10));
                coordinateModels.add(getCoordinateModel(1.5, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));
                coordinateModels.add(getCoordinateModel(1.5, 0, 10));
                coordinateModels.add(getCoordinateModel(1.5, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(.5, -1.5, 8));
                coordinateModels.add(getCoordinateModel(2.5, -1.5, 8));
                coordinateModels.add(getCoordinateModel(2.5, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut, zAbsolut);
                break;

            case 'B':
                System.out.println("B");

                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(0, -1.5, 10));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(0, -3, 10));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));


                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut, zAbsolut);
                break;

            case 'C':
                System.out.println("C");
                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut,  zAbsolut);
                break;

            case 'D':
                System.out.println("D");
                coordinateModels.add(getCoordinateModel(3, -1.5, 10));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut, zAbsolut);
                break;

            case 'E':
                System.out.println("E");
                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut, zAbsolut);
                break;

            case 'F':
                System.out.println("F");
                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, -1.5, 10));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'G':
                System.out.println("G");

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));


                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'H':
                System.out.println("H");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'I':
                System.out.println("I");
                coordinateModels.add(getCoordinateModel(1.5, 0, 10));
                coordinateModels.add(getCoordinateModel(1.5, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'J':
                System.out.println("J");

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -2, 8));
                coordinateModels.add(getCoordinateModel(0, -2, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;


            case 'K':
                System.out.println("K");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, -1.5, 10));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'L':
                System.out.println("L");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'M':
                System.out.println("M");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));


                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -1.5, 8));
                coordinateModels.add(getCoordinateModel(1.5, -1.5, 10));

                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -1.5, 8));
                coordinateModels.add(getCoordinateModel(1.5, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'N':
                System.out.println("N");
                coordinateModels.add(getCoordinateModel(0, -3, 10));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'O':
                System.out.println("O");

                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 10));


                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 10));

                coordinateModels.add(getCoordinateModel(0, -3, 10));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));


                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'P':
                System.out.println("P");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'Q':
                System.out.println("Q");
                coordinateModels.add(getCoordinateModel(3, -1.5, 10));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'R':
                System.out.println("R");

                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 10));


                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'S':
                System.out.println("S");

                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'T':
                System.out.println("T");
                coordinateModels.add(getCoordinateModel(1.5, 0, 10));
                coordinateModels.add(getCoordinateModel(1.5, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 10));

                coordinateModels.add(getCoordinateModel(0, -1.5, 10));
                coordinateModels.add(getCoordinateModel(0, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 8));
                coordinateModels.add(getCoordinateModel(3, -1.5, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'U':
                System.out.println("U");
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(3, 0, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'V':
                System.out.println("V");
                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 10));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 8));
                coordinateModels.add(getCoordinateModel(1.5, -3, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'W':
                System.out.println("W");
                break;
            case 'X':
                System.out.println("X");
                coordinateModels.add(getCoordinateModel(3, 0, 10));
                coordinateModels.add(getCoordinateModel(3, 0, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 8));
                coordinateModels.add(getCoordinateModel(0, -3, 10));


                coordinateModels.add(getCoordinateModel(3, -3, 10));
                coordinateModels.add(getCoordinateModel(3, -3, 8));
                coordinateModels.add(getCoordinateModel(1.5, -1.5, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 8));
                coordinateModels.add(getCoordinateModel(0, 0, 10));

                //angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;

            case 'Y':
                System.out.println("Y");
                break;
            case 'Z':
                System.out.println("Z");
                break;
            default:
                System.out.println("No es una letra");
                break;
        }

        return processCoordinates(coordinateModels, xAbsolut, yAbsolut, zAbsolut);

    }

    private List<AngleModel> processCoordinates(List<CoordinateModel> coordinateModels,
                                                double xAbsolut, double yAbsolut, double zAbsolut) {

        List<AngleModel> angleModels = new ArrayList<>();

        for (CoordinateModel coordinateModel : coordinateModels) {
            double xReal = xAbsolut + coordinateModel.getX();
            double yReal = yAbsolut + coordinateModel.getY();

            System.out.println("xReal: " + xReal);
            System.out.println("yReal: " + yReal);
            double z = coordinateModel.getZ();

            AngleModel angleModel = calculateInverseKinematics2(xReal, yReal);
            if (z == 8) {
                if (zAbsolut == 9) {
                    angleModel.setThetha3(98);
                } else {
                    angleModel.setThetha3(85);
                }
            } else if (z == 10) {
                if (zAbsolut == 9) {
                    angleModel.setThetha3(110);
                } else {
                    angleModel.setThetha3(100);
                }
            }
            System.out.println("theta3: " + angleModel.getThetha3());
            angleModels.add(angleModel);
        }
        return angleModels;
    }

    private CoordinateModel getCoordinateModel(double x, double y, double z) {
        CoordinateModel coordinateModel = new CoordinateModel();
        coordinateModel.setX(x);
        coordinateModel.setY(y);
        coordinateModel.setZ(z);
        return coordinateModel;
    }


    private AngleModel calculateInverseKinematics(double x, double y) {

        double L1 = 21;
        double L2 = 16.5;

        AngleModel angleModel = new AngleModel();
        double theta1 = Math.atan(y / x);
        double theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));


        angleModel.setThetha1((theta1 * 180 / Math.PI) + 180);
        angleModel.setThetha2(theta2 * 180 / Math.PI);

        System.out.println("theta1: " + angleModel.getThetha1());
        System.out.println("theta2: " + angleModel.getThetha2());


        return angleModel;
    }

    public AngleModel calculateInverseKinematics2(double x, double y) {

        double L1 = 19;
        double L2 = 15;

        AngleModel angleModel = new AngleModel();

        double theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));

        double theta1 = Math.atan2(y, x) - Math.atan2((L2 * Math.sin(theta2)), (L1 + L2 * Math.cos(theta2)));


        angleModel.setThetha1(Math.round(theta1 * 180 / Math.PI));
        angleModel.setThetha2(Math.round(theta2 * 180 / Math.PI));

        //System.out.println("theta1: " + angleModel.getThetha1());
        //System.out.println("theta2: " + angleModel.getThetha2());

        return angleModel;
    }


}
