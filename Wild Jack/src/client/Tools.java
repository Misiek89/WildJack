/**
 * 
 */
package client;

import java.awt.Point;

/**
 * @author Misiek
 * 
 */
public final class Tools {

	/**
	 * Metoda zwraca separator plik�w dla danego systemu operacyjnego<br>
	 * Windiows \<br>
	 * Linux /<br>
	 * 
	 * @return Separator plik�w danego systemu operacyjnego
	 */
	public static String fileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * Metoda zwraca koordynaty punktu w wybranej odleg�o�ci od puntku A i pod
	 * wybranym k�tem.<br>
	 * 
	 * @param A_
	 *            Punkt pocz�tkowy, dla niego szukane s� wsp�rz�dne.
	 * @param distance_
	 *            Dystans dziel�cy punkt pocz�tkowy oraz punkt szukany.
	 * @param angle_
	 *            K�t mi�dzy osi� Y przechodz�c� przez punkt pocz�tkowy i prost�
	 *            przechodz�c� przez punkty.
	 */
	public static Point findPoint(Point A_, int distance_, double angle_) {
		int X = (int) Math.round(A_.x + distance_
				* Math.sin(angle_ / 180.0 * Math.PI));
		int Y = (int) Math.round(A_.y + distance_
				* Math.cos(angle_ / 180.0 * Math.PI));
		return new Point(X, Y);
	}

	/**
	 * Metoda zwraca odleg�o�� mi�dzy 2 punktami.<br>
	 * 
	 * @param x1_
	 *            Wsp�rz�dna X punktu nr 1.
	 * @param y1_
	 *            Wsp�rz�dna Y punktu nr 1.
	 * @param x2_
	 *            Wsp�rz�dna X punktu nr 2.
	 * @param y2_
	 *            Wsp�rz�dna Y punktu nr 2.
	 * @return
	 */
	public static double distance(final int x1_, final int y1_, final int x2_,
			final int y2_) {
		return Math.sqrt(Math.pow(y1_ - y2_, 2) + Math.pow(x1_ - x2_, 2));
	}

	/**
	 * Wygodniejsza forma System.out.println().<br>
	 * Mo�e przyj�� dowolny argument, nie potrzebuje pocz�tkowego String'a.<br>
	 * 
	 * @param text_
	 *            Argument dowolny.
	 */
	public static void write(final String text_) {
		System.out.println("" + text_);
	}

	/**
	 * Metoda zwraca k�t mi�dzy prostymi przechodz�cymi mi�dzy te punkty a o� Y.<br>
	 * 
	 * @param x1_
	 *            Wsp�rz�dna X punktu nr 1.
	 * @param y1_
	 *            Wsp�rz�dna Y punktu nr 1.
	 * @param x2_
	 *            Wsp�rz�dna X punktu nr 2.
	 * @param y2_
	 *            Wsp�rz�dna Y punktu nr 2.
	 * @return
	 */
	static public double angle(final int x1_, final int y1_, final int x2_,
			final int y2_) {
		double distance = distance(x1_, y1_, x2_, y2_);
		if (distance <= 0F) {
			System.err.println("B��dne wsp�rz�dne - angle()");
			return 0;
		}
		double angle = (Math.acos((y2_ - y1_) / distance) * 180 / Math.PI);
		if (x2_ < x1_)
			angle = 360 - angle;
		return angle;
	}

	/**
	 * Metoda informuje czy podany String jest liczb� typu Int.<br>
	 * 
	 * @param num_
	 *            String
	 * @return true je�li liczba, false je�li String pusty lub nie stanowi
	 *         liczby
	 */
	static public boolean isInt(String num_) {
		try {
			int x = Integer.parseInt(num_);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
}
