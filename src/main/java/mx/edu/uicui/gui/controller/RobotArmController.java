package mx.edu.uicui.gui.controller;

import mx.edu.uicui.gui.bussines.RobotArmBusiness;
import mx.edu.uicui.gui.model.RobotArmModel;
import mx.edu.uicui.gui.view.RobotArmView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RobotArmController {

    private final RobotArmModel armModel;

    private final RobotArmView armRobotView;

    private final RobotArmBusiness robotArmBusiness;

    public RobotArmController(RobotArmModel armModel, RobotArmView robotArmView, RobotArmBusiness robotArmBusiness) {
        this.armModel = armModel;
        this.armRobotView = robotArmView;
        this.robotArmBusiness = robotArmBusiness;


        this.armRobotView.addJButtonEnterActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter");
                sendData();

            }
        });

        this.armRobotView.addJButtonConectarActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(armModel.isIsConected()){
                    disconnect();
                }else {
                    connect();
                }

            }
        });

        this.armRobotView.addJButtonRefreshActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Refresh");
                getPorts();

            }
        });
    }

    private void getPorts() {
        this.armModel.setPuertos(this.robotArmBusiness.getPorts());
        armRobotView.setPuertos(armModel.getPuertos());
        if(this.armModel.getPuertos() != null) {
            this.armModel.setHasPort(true);
            this.armRobotView.updateView();
        }
    }

    private void sendData() {
        armModel.setWord(armRobotView.getWord());
        System.out.println(armModel.getWord());
        this.robotArmBusiness.sendData(armModel.getWord());

    }

    private void connect() {
        System.out.println("Conectar");
        armModel.setPuerto(armRobotView.getSelectedPort());
        System.out.println(armModel.getPuerto());
        this.robotArmBusiness.connect(armModel.getPuerto());
        this.armModel.setIsConected(true);
        this.armRobotView.updateView();

    }

    private void disconnect() {
        System.out.println("Desconectar");
        //armModel.setPuerto(armRobotView.getSelectedPort());
        System.out.println(armModel.getPuerto());
        this.robotArmBusiness.disconnect();
        this.armModel.setIsConected(false);
        this.armRobotView.updateView();

    }
}
