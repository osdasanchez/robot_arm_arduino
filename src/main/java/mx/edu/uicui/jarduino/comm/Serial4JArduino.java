
package mx.edu.uicui.jarduino.comm;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;
import mx.edu.uicui.jarduino.observer.JArduinoClientObserver;
import mx.edu.uicui.jarduino.observer.JArduinoObserver;
import mx.edu.uicui.jarduino.observer.JArduinoSubject;

import java.util.HashSet;
import java.util.Set;

public class Serial4JArduino implements JArduinoClientObserver, JArduinoSubject {

    public static final byte START_BYTE = 0x12;
    public static final byte STOP_BYTE = 0x13;
    public static final byte ESCAPE_BYTE = 0x7D;
    public static final int DEFAULT_BAUD = 9600;
    protected String port;
    protected SerialPort serialPort;


    public Serial4JArduino() {
    }
    public Serial4JArduino(String port) {
    	this(port, new SerialConfiguration(DEFAULT_BAUD));
    }
    
    public Serial4JArduino(String port, SerialConfiguration conf) {
        this.port = port;
        connect(port);
    }
    
    public void connect(String portName) {
    	this.connect(portName,  new SerialConfiguration(DEFAULT_BAUD));
    }

    public void connect(String portName, SerialConfiguration conf) {


       // SerialPort port = new SerialPort(portName);
        serialPort = new SerialPort(portName);
        try {
            serialPort.openPort();
            serialPort.setParams(conf.getBaudRate(),  SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }

    }

    public void disconnect() {
        try {
            serialPort.closePort();
        } catch (SerialPortException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isConnected() {
        return serialPort.isOpened();
    }

    public String [] getPortList() {
        for(String port : SerialPortList.getPortNames()) {
            System.out.println(port);
        }
        return SerialPortList.getPortNames();
    }



    /* ***********************************************************************
     * Implementation of the CoffeeSensorClientObserver interface. 
     * The receiveMsg method gets called with packets to send.
     *************************************************************************/
    @Override
    public void receiveMsg(byte[] msg) {
        sendData(msg);
    }

    /* ***********************************************************************
     * Implementation of the CoffeeSensorSubject interface. 
     * The CoffeeSensor Observers get notified for each incoming packet.
     *************************************************************************/
    Set<JArduinoObserver> observers = new HashSet<JArduinoObserver>();

    @Override
    public void register(JArduinoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(JArduinoObserver observer) {
        observers.remove(observer);
    }

    /* ***********************************************************************
     * Serial Port data send operation
     *************************************************************************/
    protected void sendData(byte[] payload) {

        try {
            // send the start byte
            serialPort.writeByte( START_BYTE);
            // send data
            for (int i = 0; i < payload.length; i++) {
                // escape special bytes
                if (payload[i] == START_BYTE || payload[i] == STOP_BYTE || payload[i] == ESCAPE_BYTE) {
                    serialPort.writeByte(ESCAPE_BYTE);
                }
                serialPort.writeByte( payload[i]);
            }
            // send the stop byte
            serialPort.writeByte( STOP_BYTE);
        }  catch (SerialPortException e) {
            e.printStackTrace();
        }
    }


}
