package client;

import javax.swing.*;

/**
 * G³owne okno wywo³ywane u klienta.<br>
 * @author Misiek
 * @date 25.04.13
 */
public class GUI extends JFrame{
	private static final long serialVersionUID = 6320267031862877494L;
	private int Fx = 40, Fy = 20, Fw = 1000, Fh = 700;
	
	
	public GUI(){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}
	
	private void createGUI(){
		
	}
	public static void main(String[] args) {

	}
}
