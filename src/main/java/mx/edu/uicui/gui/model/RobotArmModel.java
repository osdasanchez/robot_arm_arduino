package mx.edu.uicui.gui.model;

public class RobotArmModel {

    private String [] puertos;
    private String puerto;
    private String word;

    private boolean isConected;

    private boolean hasPort;

    public String[] getPuertos() {
        return puertos;
    }

    public void setPuertos(String[] puertos) {
        this.puertos = puertos;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isIsConected() {
        return isConected;
    }

    public void setIsConected(boolean isConected) {
        this.isConected = isConected;
    }

    public boolean isHasPort() {
        return hasPort;
    }

    public void setHasPort(boolean hasPort) {
        this.hasPort = hasPort;
    }
}
