package client;

import java.awt.image.BufferedImage;

import javax.swing.*;

import server.COLOR;
import server.VALUE;

/**
 * Graficzna reprezentacja karty do gry u klienta.<br>
 * @author Misiek
 * @date 25.04.13
 */
public class GraphCard extends JButton{
	private static final long serialVersionUID = 4761327911735863823L;
	private int Bx, By, Bw, Bh;
	private static BufferedImage[][] BICards;
	
	public GraphCard(COLOR color_, VALUE value_){
		
	}
	
	static{
		BICards = new BufferedImage [4][4];
		for(COLOR i : COLOR.values())
			for(VALUE j : VALUE.values()){
				
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
