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


        int i = 1;
        for (char letter : letters) {
            List<AngleModel> angleModels =
                    calculateAngles(letter, corrdinatesMap.get(i).getX(), corrdinatesMap.get(i).getY());
            i++;
        }

    }

    public List<AngleModel> calculateAngles(char letter, double xAbsolut, double yAbsolut) {
        List<AngleModel> angleModels = new ArrayList<>();
        List<CoordinateModel> coordinateModels = null;
        CoordinateModel coordinate1 ;
        CoordinateModel coordinate2 ;
        CoordinateModel coordinate3;
        CoordinateModel coordinate4 ;
        CoordinateModel coordinate5 ;
        CoordinateModel coordinate6 ;
        CoordinateModel coordinate7 ;
        CoordinateModel coordinate8;
        CoordinateModel coordinate9;

        switch (letter) {
            case 'A':
                System.out.println("A");
                coordinateModels = new ArrayList<>();
                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(2);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(2);
                coordinate4.setY(-2);
                coordinate4.setZ(10);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0.5);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1.5);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

              coordinate7 = new CoordinateModel();
                coordinate7.setX(1.5);
                coordinate7.setY(-1);
                coordinate7.setZ(10);



                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);


                break;
            case 'B':
                System.out.println("B");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-1);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1);
                coordinate7.setY(0);
                coordinate7.setZ(8);

                coordinate8 = new CoordinateModel();
                coordinate8.setX(0);
                coordinate8.setY(0);
                coordinate8.setZ(8);

                coordinate9 = new CoordinateModel();
                coordinate9.setX(0);
                coordinate9.setY(0);
                coordinate9.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);
                coordinateModels.add(coordinate8);
                coordinateModels.add(coordinate9);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'C':
                System.out.println("C");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1.5);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1.5);
                coordinate5.setY(0);
                coordinate5.setZ(10);


                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'D':
                System.out.println("D");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1.5);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1.5);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-1);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-2);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-2);
                coordinate6.setZ(10);



                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'E':
                System.out.println("E");

                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1.5);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(0);
                coordinate4.setY(0);
                coordinate4.setZ(10);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(0);
                coordinate7.setY(-1);
                coordinate7.setZ(10);



                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'F':
                System.out.println("F");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(0);
                coordinate4.setZ(10);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(0);
                coordinate7.setY(-1);
                coordinate7.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);

                break;
            case 'G':
                System.out.println("G");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1.5);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-2);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1.5);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(0);
                coordinate7.setY(-1);
                coordinate7.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'H':
                System.out.println("H");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(0);
                coordinate3.setZ(10);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(2);
                coordinate4.setY(-2);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(2);
                coordinate5.setY(0);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(2);
                coordinate6.setY(0);
                coordinate6.setZ(10);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(2);
                coordinate7.setY(-1);
                coordinate7.setZ(8);

                coordinate8 = new CoordinateModel();
                coordinate8.setX(0);
                coordinate8.setY(-1);
                coordinate8.setZ(8);

                coordinate9 = new CoordinateModel();
                coordinate9.setX(0);
                coordinate9.setY(-1);
                coordinate9.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);
                coordinateModels.add(coordinate8);
                coordinateModels.add(coordinate9);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'I':
                System.out.println("I");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(0);
                coordinate3.setZ(10);


                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'J':
                System.out.println("J");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1);
                coordinate4.setY(0);
                coordinate4.setZ(10);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0.5);
                coordinate5.setY(0);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1.5);
                coordinate6.setY(0);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1.5);
                coordinate7.setY(0);
                coordinate7.setZ(10);


                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'K':
                System.out.println("K");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(0);
                coordinate3.setY(0);
                coordinate3.setZ(10);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-2);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1.5);
                coordinate6.setY(0);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1.5);
                coordinate7.setY(0);
                coordinate7.setZ(10);



                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'L':
                System.out.println("L");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-2);
                coordinate4.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'M':
                System.out.println("M");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(-1);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(2);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(2);
                coordinate5.setY(-2);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(2);
                coordinate6.setY(-2);
                coordinate6.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'N':
                System.out.println("N");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1);
                coordinate5.setY(0);
                coordinate5.setZ(10);


                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'O':
                System.out.println("O");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-2);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-2);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-2);
                coordinate6.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'P':
                System.out.println("P");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(-1);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(0);
                coordinate6.setY(-1);
                coordinate6.setZ(10);



                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'Q':
                System.out.println("Q");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1.5);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1.5);
                coordinate2.setY(-1);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(-0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(0);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1.5);
                coordinate6.setY(-1);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1.5);
                coordinate7.setY(-1);
                coordinate7.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'R':
                System.out.println("R");

                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1);
                coordinate4.setY(-1);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(-1);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1);
                coordinate6.setY(-2);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1);
                coordinate7.setY(-2);
                coordinate7.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'S':
                System.out.println("S");

                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1.5);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(-1);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(0);
                coordinate4.setY(-1);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(0);
                coordinate5.setY(0);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(1.5);
                coordinate6.setY(0);
                coordinate6.setZ(8);

                coordinate7 = new CoordinateModel();
                coordinate7.setX(1.5);
                coordinate7.setY(0);
                coordinate7.setZ(10);


                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);
                coordinateModels.add(coordinate7);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'T':
                System.out.println("T");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(1);
                coordinate1.setY(-2);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1);
                coordinate2.setY(0);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1);
                coordinate3.setY(0);
                coordinate3.setZ(10);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(0);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(2);
                coordinate5.setY(0);
                coordinate5.setZ(8);

                coordinate6 = new CoordinateModel();
                coordinate6.setX(2);
                coordinate6.setY(0);
                coordinate6.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);
                coordinateModels.add(coordinate6);

                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'U':
                System.out.println("U");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(0);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(1.5);
                coordinate3.setY(-2);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(1.5);
                coordinate4.setY(0);
                coordinate4.setZ(8);

                coordinate5 = new CoordinateModel();
                coordinate5.setX(1.5);
                coordinate5.setY(0);
                coordinate5.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);
                coordinateModels.add(coordinate5);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'V':
                System.out.println("V");
                coordinateModels = new ArrayList<>();

                coordinate1 = new CoordinateModel();
                coordinate1.setX(0);
                coordinate1.setY(0);
                coordinate1.setZ(8);

                coordinate2 = new CoordinateModel();
                coordinate2.setX(1);
                coordinate2.setY(-2);
                coordinate2.setZ(8);

                coordinate3 = new CoordinateModel();
                coordinate3.setX(2);
                coordinate3.setY(0);
                coordinate3.setZ(8);

                coordinate4 = new CoordinateModel();
                coordinate4.setX(2);
                coordinate4.setY(0);
                coordinate4.setZ(10);

                coordinateModels.add(coordinate1);
                coordinateModels.add(coordinate2);
                coordinateModels.add(coordinate3);
                coordinateModels.add(coordinate4);


                angleModels = processCoordinates(coordinateModels, xAbsolut, yAbsolut);
                break;
            case 'W':
                System.out.println("W");
                break;
            case 'X':
                System.out.println("X");
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

        return angleModels;

    }

    private List<AngleModel> processCoordinates(List<CoordinateModel> coordinateModels,
                                                double xAbsolut, double yAbsolut){

        List<AngleModel> angleModels = new ArrayList<>();

        for (CoordinateModel coordinateModel : coordinateModels) {
            double xReal = xAbsolut + coordinateModel.getX();
            double yReal = yAbsolut + coordinateModel.getY();

            System.out.println("xReal: " + xReal);
            System.out.println("yReal: " + yReal);
            double z = coordinateModel.getZ();

            AngleModel angleModel = calculateInverseKinematics2(xReal, yReal);
            if(z == 8){
                angleModel.setThetha3(90);
            } else if (z == 10){
                angleModel.setThetha3(90);
            }
            System.out.println("theta3: " + angleModel.getThetha3());
            angleModels.add(angleModel);
        }
        return angleModels;
    }


    private AngleModel calculateInverseKinematics(double x, double y) {

        double L1 = 21;
        double L2 = 16.5;

        AngleModel angleModel = new AngleModel();
        double theta1 = Math.atan(y / x);
        double theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));



        angleModel.setThetha1( (theta1 * 180 / Math.PI) +180);
        angleModel.setThetha2(theta2 * 180 / Math.PI);

        System.out.println("theta1: " + angleModel.getThetha1());
        System.out.println("theta2: " + angleModel.getThetha2());


        return angleModel;
    }

    public AngleModel calculateInverseKinematics2(double x, double y) {

        double L1 = 20;
        double L2 = 16;

        AngleModel angleModel = new AngleModel();

       double theta2 = Math.acos((Math.pow(x, 2) + Math.pow(y, 2) - Math.pow(L1, 2) - Math.pow(L2, 2)) / (2 * L1 * L2));

       double theta1 = Math.atan2(y,x) - Math.atan2((L2 * Math.sin(theta2)) , (L1 + L2 * Math.cos(theta2)));


        angleModel.setThetha1((theta1  * 180 / Math.PI ));
        angleModel.setThetha2((theta2 * 180 / Math.PI ));

        System.out.println("theta1: " + angleModel.getThetha1());
        System.out.println("theta2: " + angleModel.getThetha2());

        return angleModel;
    }


}
