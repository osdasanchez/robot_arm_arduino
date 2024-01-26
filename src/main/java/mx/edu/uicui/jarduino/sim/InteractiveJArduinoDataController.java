
package mx.edu.uicui.jarduino.sim;

import mx.edu.uicui.jarduino.*;
import mx.edu.uicui.jarduino.observer.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unused")
public class InteractiveJArduinoDataController implements ActionListener, JArduinoClientObserver, JArduinoSubject {


	private List<JArduinoObserver> handlers;
	
	private SimpleDateFormat dateFormat;

	public InteractiveJArduinoDataController(){
		handlers = new LinkedList<JArduinoObserver>();
		dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");
		InteractiveJArduinoDataGUI.init();
		InteractiveJArduinoDataGUI.addListener(this);
		InteractiveJArduinoDataGUI.handler = this;	
	}
	
	

	private void doSend(FixedSizePacket data){
		if (data != null) {
        	System.out.println(data+" --> "+data.getPacket());
            for (JArduinoObserver h : handlers){
				h.receiveMsg(data.getPacket());
			}
        }
        else {
        	System.out.println("Data is null");
        }
	}

	public final void senddigitalReadResult() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		DigitalState value = null;
		try{
			value = (DigitalState)InteractiveJArduinoDataGUI.getFielddigitalReadResultValue().getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = JArduinoProtocol.createDigitalReadResult(value);
			doSend(fsp);
		}
	}

	public final void sendanalogReadResult() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Short value = null;
		try{
			value = Short.parseShort(InteractiveJArduinoDataGUI.getFieldanalogReadResultValue().getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = JArduinoProtocol.createAnalogReadResult(value);
			doSend(fsp);
		}
	}

	public final void sendpong() {
		FixedSizePacket fsp = null;
		fsp = JArduinoProtocol.createPong();	
		doSend(fsp);
	}

	public final void sendinterruptNotification() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		InterruptPin interrupt = null;
		try{
			interrupt = (InterruptPin)InteractiveJArduinoDataGUI.getFieldinterruptNotificationInterrupt().getSelectedItem();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = JArduinoProtocol.createInterruptNotification(interrupt);
			doSend(fsp);
		}
	}

	public final void sendeeprom_value() {
		FixedSizePacket fsp = null;
		boolean valid = true;
		Byte value = null;
		try{
			value = Byte.parseByte(InteractiveJArduinoDataGUI.getFieldeeprom_valueValue().getText());
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(new JFrame(), "Please check that all the inputs have the right type", "Error: Invalid input", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (valid){
			fsp = JArduinoProtocol.createEeprom_value(value);
			doSend(fsp);
		}
	}

	public final void sendeeprom_write_ack() {
		FixedSizePacket fsp = null;
		fsp = JArduinoProtocol.createEeprom_write_ack();	
		doSend(fsp);
	}


	public final void receiveMessage(byte[] packet){
		FixedSizePacket data = JArduinoProtocol.createMessageFromPacket(packet);
		if (data != null) {
			InteractiveJArduinoDataGUI.print(data.getClass().getSimpleName(), "["+dateFormat.format(new Date(System.currentTimeMillis()))+"]: "+data.toString()+" --> "+FixedSizePacket.toString(packet));
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtondigitalReadResult()) {
		 	senddigitalReadResult();
		 }
		 else if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtonanalogReadResult()) {
		 	sendanalogReadResult();
		 }
		 else if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtonpong()) {
		 	sendpong();
		 }
		 else if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtoninterruptNotification()) {
		 	sendinterruptNotification();
		 }
		 else if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtoneeprom_value()) {
		 	sendeeprom_value();
		 }
		 else if ( ae.getSource() == InteractiveJArduinoDataGUI.getSendButtoneeprom_write_ack()) {
		 	sendeeprom_write_ack();
		 }
	}
	
	public static void main(String args[]){
		InteractiveJArduinoDataController controller = new InteractiveJArduinoDataController();
	}
	


	//Methods defined in the Observer pattern specific to JArduino 
	@Override
	public void receiveMsg(byte[] msg) {
		receiveMessage(msg);
	}
	
	@Override
	public void register(JArduinoObserver observer) {
		handlers.add(observer);
	}

	@Override
	public void unregister(JArduinoObserver observer) {
		handlers.remove(observer);
	}
}