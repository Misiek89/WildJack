package client;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * G³owne okno wywo³ywane u klienta.<br>
 * 
 * @author Misiek
 * @date 25.04.13
 */
public class GUI extends JFrame {
	private static final long serialVersionUID = 6320267031862877494L;
	private final int Fx = 40, Fy = 20, Fw = 1000, Fh = 700;
	private final String Ftitle = "Wild Jack";
	private final static String fs = Tools.fileSeparator();
	private static BufferedImage BIback, BIicon;
	private static HashMap<String, BufferedImage> HMcards;
	private MenuView menu;
	private GameView game;
	private JLabel Lbackground;

	public GUI() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
	}

	private void createGUI() {
		this.setBounds(Fx, Fy, Fw, Fh);
		this.setTitle(Ftitle);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(BIicon);
		this.setResizable(false);

		menu = new MenuView(Fw, Fh, this);
		this.add(menu);

		game = new GameView(Fw, Fh, this);
		this.add(game);

		Lbackground = new JLabel(new ImageIcon(BIback));
		Lbackground.setBounds(0, 0, Lbackground.getIcon().getIconWidth(),
				Lbackground.getIcon().getIconHeight());
		this.add(Lbackground);

		this.setVisible(true);
	}

	// METHOD
	public void connectToServer() {
		if (menu.getNick().length() < 3) {
			menu.showWarning("Correct your nick");
			return;
		}

		if (menu.getServerAddress().isEmpty()) {
			menu.showWarning("Correct server address");
			return;
		}

		// TODO Po³¹cz z wybranym serwerem

		menu.setState(STATE.connectedToServer);
	}

	public void launchServer() {
		if (menu.getState() == STATE.newServer) {
			int port = 0;

			// Check parametrers
			if (menu.getNick().length() < 3) {
				menu.showWarning("Correct your nick");
				return;
			}

			if (Tools.isInt(menu.getServerPort())) {
				port = Integer.parseInt(menu.getServerPort());
				if (port < 0 || port > 65535) {
					menu.showWarning("Correct server port");
					return;
				}
			} else {
				menu.showWarning("Correct server port");
				return;
			}

			if (menu.getServerTitle().length() < 3) {
				menu.showWarning("Correct server title");
				return;
			}

			// Launch server

			menu.setState(STATE.serverLaunched);
			menu.showWarning("Server launched");
		}
	}

	public void disconnectFromServer() {
		if (menu.getState() == STATE.connectedToServer) {
			// TODO disconnect
			menu.setState(STATE.joinServer);
			menu.showWarning("Disconnected from server");
		}
	}

	public void disableServer() {
		if (menu.getState() == STATE.serverLaunched) {
			// TODO disconnect
			menu.setState(STATE.newServer);
			menu.showWarning("Server disabled");
		}
	}

	// MAIN
	public static void main(String[] args) {
		new GUI();
	}

	static {
		try {
			BIback = ImageIO.read(GUI.class.getClassLoader().getResource(
					"Media" + fs + "Background.jpg"));
			BIicon = ImageIO.read(GUI.class.getClassLoader().getResource(
					"Media" + fs + "Icon.png"));
		} catch (Exception e) {
			System.err.println("Image loading error - GUI static{...}!");
			System.exit(-1);
		}
	}
}
