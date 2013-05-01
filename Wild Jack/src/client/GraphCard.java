package client;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import server.COLOR;
import server.VALUE;

/**
 * Graficzna reprezentacja karty do gry u klienta.<br>
 * 
 * @author Misiek
 * @date 25.04.13
 */
public class GraphCard extends JButton {
	private static final long serialVersionUID = 4761327911735863823L;
	private static BufferedImage[][] BICards;
	private static BufferedImage BIEmptyCard;
	private COLOR color;
	private VALUE value;
	private boolean tag;

	// CONSTRUCTOR
	public GraphCard(COLOR color_, VALUE value_) {
		if (color_ != null || value_ != null) {
			color = color_;
			value = value_;
			this.setIcon(new ImageIcon(BICards[color.getInt()][value.getInt()]));
			this.setSize(this.getIcon().getIconWidth(), this.getIcon()
					.getIconHeight());

		} else
			throw new IllegalArgumentException("NULL args - GraphCard()!");
	}

	public GraphCard() {
		this.setIcon(new ImageIcon(BIEmptyCard));
		this.setSize(this.getIcon().getIconWidth(), this.getIcon()
				.getIconHeight());
	}

	// GET & SET
	public COLOR getColor() {
		return color;
	}

	public VALUE getValue() {
		return value;
	}

	public boolean isTagged() {
		return tag;
	}

	public void setTagged(boolean tagged_) {
		tag = tagged_;
	}

	// METHOD
	public String toString() {
		return GraphCard.class.getSimpleName() + " > " + this.getColor() + ":"
				+ this.getValue();
	}

	// STATIC
	static {
		try {
			int m = 0, n = 0;
			BIEmptyCard = ImageIO.read(GUI.class.getClassLoader().getResource(
					"Media" + Tools.fileSeparator() + "Invert_V.png"));
			BICards = new BufferedImage[COLOR.values().length][VALUE.values().length];
			for (COLOR i : COLOR.values())
				for (VALUE j : VALUE.values()) {
					m = i.getInt();
					n = j.getInt();
					BICards[m][n] = ImageIO.read(GUI.class.getClassLoader()
							.getResource(
									"Media" + Tools.fileSeparator() + m + "_"
											+ n + ".png"));
				}
		} catch (IOException e) {
			System.err.println("B³¹d wczytywania obrazka!");
		}
	}
}
