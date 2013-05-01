package client;

import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.Border;

public class MenuView extends JComponent implements ActionListener {
	private static final long serialVersionUID = 4327319702072030622L;
	private int Fw = 1000, Fh = 700;
	private int Bx = 50, By = 200, Bw = 200, Bh = 40;
	private int Tx = 50, Ty = 200, Tw = 200, Th = 50;
	private JLabel Ltitle;
	private JButton Bnew, Bjoin, Bback, Blaunch, Bconnect, Bready;
	private JTextField Tnick, TserverTitle, TserverAddress, TserverPort;
	private Border Bline = BorderFactory.createLineBorder(Color.BLACK, 2);
	private Border TBnick = BorderFactory.createTitledBorder(Bline, "Nick");
	private Border TBServerTitle = BorderFactory.createTitledBorder(Bline,
			"Server title");
	private Border TBServerAddress = BorderFactory.createTitledBorder(Bline,
			"Server address");
	private Border TBServerPort = BorderFactory.createTitledBorder(Bline,
			"Server port");
	private static BufferedImage BItitle;
	private GUI gui;
	private STATE state;

	public MenuView(int Fw_, int Fh_, GUI gui_) {
		if (Fw_ > 0 && Fh_ > 0 && gui_ != null) {
			Fw = Fw_;
			Fh = Fh_;
			gui = gui_;
			this.createMenu();
		} else {
			throw new IllegalArgumentException("Wrong arg - MenuView()!");
		}
	}

	private void createMenu() {
		this.setBounds(0, 0, Fw, Fh);
		this.setLayout(null);

		Ltitle = new JLabel(new ImageIcon(BItitle));
		Ltitle.setBounds(Fw / 2 - Ltitle.getIcon().getIconWidth() / 2, 20,
				Ltitle.getIcon().getIconWidth(), Ltitle.getIcon()
						.getIconHeight());
		this.add(Ltitle);

		Bnew = new JButton("New server");
		Bnew.setBounds(Bx, By, Bw, Bh);
		Bnew.setActionCommand("NewServer");
		Bnew.setOpaque(false);
		Bnew.setBorder(Bline);
		Bnew.addActionListener(this);
		this.add(Bnew);

		Bjoin = new JButton("Join server");
		Bjoin.setBounds(Bx, By + Bh * 2, Bw, Bh);
		Bjoin.setActionCommand("JoinServer");
		Bjoin.setOpaque(false);
		Bjoin.setBorder(Bline);
		Bjoin.addActionListener(this);
		this.add(Bjoin);

		Blaunch = new JButton("Launch");
		Blaunch.setBounds(Bx, By + Bh * 8, Bw, Bh);
		Blaunch.setActionCommand("Launch");
		Blaunch.setOpaque(false);
		Blaunch.setBorder(Bline);
		Blaunch.setVisible(false);
		Blaunch.addActionListener(this);
		this.add(Blaunch);

		Bconnect = new JButton("Connect");
		Bconnect.setBounds(Bx, By + Bh * 8, Bw, Bh);
		Bconnect.setActionCommand("Connect");
		Bconnect.setOpaque(false);
		Bconnect.setBorder(Bline);
		Bconnect.setVisible(false);
		Bconnect.addActionListener(this);
		this.add(Bconnect);

		Bback = new JButton("Back");
		Bback.setBounds(Bx, By + Bh * 10, Bw, Bh);
		Bback.setActionCommand("Back");
		Bback.setOpaque(false);
		Bback.setBorder(Bline);
		Bback.setVisible(false);
		Bback.addActionListener(this);
		this.add(Bback);

		Tnick = new JTextField();
		Tnick.setBounds(Tx, Ty, Tw, Th);
		Tnick.setOpaque(false);
		Tnick.setVisible(false);
		Tnick.setBorder(TBnick);
		this.add(Tnick);

		TserverAddress = new JTextField();
		TserverAddress.setBounds(Tx, Ty + Th * 2, Tw, Th);
		TserverAddress.setOpaque(false);
		TserverAddress.setVisible(false);
		TserverAddress.setBorder(TBServerAddress);
		this.add(TserverAddress);

		TserverPort = new JTextField();
		TserverPort.setBounds(Tx, Ty + Th * 2, Tw, Th);
		TserverPort.setOpaque(false);
		TserverPort.setVisible(false);
		TserverPort.setBorder(TBServerPort);
		this.add(TserverPort);

		TserverTitle = new JTextField();
		TserverTitle.setBounds(Tx, Ty + Th * 4, Tw, Th);
		TserverTitle.setOpaque(false);
		TserverTitle.setVisible(false);
		TserverTitle.setBorder(TBServerTitle);
		this.add(TserverTitle);

		this.setVisible(true);
	}

	static {
		try {
			BItitle = ImageIO.read(GUI.class.getClassLoader().getResource(
					"Media" + Tools.fileSeparator() + "Title.png"));
		} catch (Exception e) {
			System.err.println("Image loading error - GUI static{...}!");
			System.exit(-1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand().trim();

		switch (src) {
		case "NewServer":
			this.setState(STATE.newServer);
			break;
		case "JoinServer":
			this.setState(STATE.joinServer);
			break;
		case "Back":
			this.setState(STATE.mainMenu);
			break;
		case "Launch":
			if (state == STATE.newServer)
				gui.launchServer();
			else
				gui.disableServer();
			break;
		case "Connect":
			if (state == STATE.joinServer)
				gui.connectToServer();
			else
				gui.disconnectFromServer();
			break;
		default:
			System.err.println("Empty String - actionPerformed()!");
			return;
		}
	}

	// GET
	public String getNick() {
		if (Tnick != null)
			return Tnick.getText().trim();
		else
			return null;
	}

	public String getServerTitle() {
		if (TserverTitle != null)
			return TserverTitle.getText().trim();
		else
			return null;
	}

	public String getServerAddress() {
		if (TserverAddress != null)
			return TserverAddress.getText().trim();
		else
			return null;
	}

	public String getServerPort() {
		if (TserverPort != null)
			return TserverPort.getText().trim();
		else
			return null;
	}

	public STATE getState() {
		return state;
	}

	// METHOD
	/**
	 * Zmienia widocznoœæ oraz mo¿liwoœæ edycji komponentów panulu menu.<br>
	 * 
	 * @param state
	 *            enum STATE
	 */
	public void setState(STATE state_) {
		if (state_ != null) {
			state = state_;

			Tnick.setVisible(state != STATE.mainMenu
					&& state != STATE.gameStarted);
			Tnick.setEditable(state == STATE.joinServer
					|| state == STATE.newServer);

			TserverTitle.setVisible(state != STATE.mainMenu
					&& state != STATE.gameStarted && state != STATE.joinServer);
			TserverTitle.setEditable(state == STATE.newServer);

			TserverAddress.setVisible(state == STATE.joinServer
					|| state == STATE.connectedToServer);
			TserverAddress.setEditable(state == STATE.joinServer);

			TserverPort.setVisible(state == STATE.newServer
					|| state == STATE.serverLaunched);
			TserverPort.setEditable(state == STATE.newServer);

			Bnew.setVisible(state == STATE.mainMenu);

			Bjoin.setVisible(state == STATE.mainMenu);

			Blaunch.setVisible(state == STATE.newServer
					|| state == STATE.serverLaunched);
			Blaunch.setText(state == STATE.newServer ? "Launch" : "Disable");

			Bconnect.setVisible(state == STATE.joinServer
					|| state == STATE.connectedToServer);
			Bconnect.setText(state == STATE.joinServer ? "Connect"
					: "Disconnect");

			Bback.setVisible(state != STATE.mainMenu
					&& state != STATE.serverLaunched
					&& state != STATE.connectedToServer);
		
			if(state == STATE.mainMenu){
				Tnick.setText("");
				TserverAddress.setText("");
				TserverPort.setText("");
				TserverTitle.setText("");
			}
		}
	}

	/**
	 * Wyœwietla ostrze¿enie lub informacjê na panelu menu.
	 * 
	 * @param message_
	 *            Wiadomoœæ przychodz¹ca
	 */
	public void showWarning(String message_) {
		final String message = message_;
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JOptionPane.showMessageDialog(null, message);
			}
		});
	}
}
