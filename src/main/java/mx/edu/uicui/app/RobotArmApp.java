package mx.edu.uicui.app;

import mx.edu.uicui.gui.bussines.LetterBusiness;
import mx.edu.uicui.gui.bussines.RobotArmBusiness;
import mx.edu.uicui.gui.controller.RobotArmController;
import mx.edu.uicui.gui.model.RobotArmModel;
import mx.edu.uicui.gui.view.RobotArmView;
import mx.edu.uicui.jarduino.comm.Serial4JArduino;

public class RobotArmApp {
    private RobotArmModel armModel;
    private RobotArmView robotArmView;

    private RobotArmBusiness robotArmBusiness;

    private Serial4JArduino serial4JArduino;

    private LetterBusiness letterBusiness;

    public RobotArmApp() {
        start();
    }

    private void start() {
        this.armModel = new RobotArmModel();
        this.robotArmView = new RobotArmView(armModel);
        this.serial4JArduino = new Serial4JArduino();
        this.letterBusiness = new LetterBusiness();
        this.robotArmBusiness = new RobotArmBusiness(serial4JArduino, letterBusiness);
        new RobotArmController(armModel, robotArmView, robotArmBusiness);
        robotArmView.setVisible(true);
    }
}
