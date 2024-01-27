package mx.edu.uicui.gui.bussines;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ArduinoControl {

    public static final byte START_BYTE = 0x12;
    public static final byte STOP_BYTE = 0x13;
    public static final byte ESCAPE_BYTE = 0x7D;
    public static final int DEFAULT_BAUD = 9600;

    private SerialPort serialPort;



    public String[] getPorts() {
        return SerialPortList.getPortNames();
    }

    public void connect(String portName) {
        // SerialPort port = new SerialPort(portName);
        serialPort = new SerialPort(portName);
        try {
            serialPort.openPort();
            serialPort.setParams(DEFAULT_BAUD, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
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

    public void send(String data) {


        sendData(data.getBytes(StandardCharsets.UTF_8));
    }

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

    private  void sendDataString(String data) throws SerialPortException {
        try {
            serialPort.writeString(data);
            Thread.sleep(1000);
        } catch (SerialPortException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
