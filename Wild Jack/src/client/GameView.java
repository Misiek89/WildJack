package client;

import javax.swing.JComponent;

public class GameView extends JComponent {
	private static final long serialVersionUID = 6162080886225274884L;
	private int Fw = 1000, Fh = 700;
	private GUI gui;

	public GameView(int Fw_, int Fh_, GUI gui_) {
		if (Fw_ > 0 && Fh_ > 0 && gui_ != null) {
			Fw = Fw_;
			Fh = Fh_;
			gui = gui_;
			this.createMenu();
		} else {
			throw new IllegalArgumentException("Wrong arg - GameView()!");
		}
	}

	private void createMenu() {
		this.setBounds(0, 0, Fw, Fh);
		this.setLayout(null);

		this.setVisible(true);
	}
}
