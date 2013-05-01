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
	 * Metoda zwraca separator plików dla danego systemu operacyjnego<br>
	 * Windiows \<br>
	 * Linux /<br>
	 * 
	 * @return Separator plików danego systemu operacyjnego
	 */
	public static String fileSeparator() {
		return System.getProperty("file.separator");
	}

	/**
	 * Metoda zwraca koordynaty punktu w wybranej odleg³oœci od puntku A i pod
	 * wybranym k¹tem.<br>
	 * 
	 * @param A_
	 *            Punkt pocz¹tkowy, dla niego szukane s¹ wspó³rzêdne.
	 * @param distance_
	 *            Dystans dziel¹cy punkt pocz¹tkowy oraz punkt szukany.
	 * @param angle_
	 *            K¹t miêdzy osi¹ Y przechodz¹c¹ przez punkt pocz¹tkowy i prost¹
	 *            przechodz¹c¹ przez punkty.
	 */
	public static Point findPoint(Point A_, int distance_, double angle_) {
		int X = (int) Math.round(A_.x + distance_
				* Math.sin(angle_ / 180.0 * Math.PI));
		int Y = (int) Math.round(A_.y + distance_
				* Math.cos(angle_ / 180.0 * Math.PI));
		return new Point(X, Y);
	}

	/**
	 * Metoda zwraca odleg³oœæ miêdzy 2 punktami.<br>
	 * 
	 * @param x1_
	 *            Wspó³rzêdna X punktu nr 1.
	 * @param y1_
	 *            Wspó³rzêdna Y punktu nr 1.
	 * @param x2_
	 *            Wspó³rzêdna X punktu nr 2.
	 * @param y2_
	 *            Wspó³rzêdna Y punktu nr 2.
	 * @return
	 */
	public static double distance(final int x1_, final int y1_, final int x2_,
			final int y2_) {
		return Math.sqrt(Math.pow(y1_ - y2_, 2) + Math.pow(x1_ - x2_, 2));
	}

	/**
	 * Wygodniejsza forma System.out.println().<br>
	 * Mo¿e przyj¹æ dowolny argument, nie potrzebuje pocz¹tkowego String'a.<br>
	 * 
	 * @param text_
	 *            Argument dowolny.
	 */
	public static void write(final String text_) {
		System.out.println("" + text_);
	}

	/**
	 * Metoda zwraca k¹t miêdzy prostymi przechodz¹cymi miêdzy te punkty a oœ Y.<br>
	 * 
	 * @param x1_
	 *            Wspó³rzêdna X punktu nr 1.
	 * @param y1_
	 *            Wspó³rzêdna Y punktu nr 1.
	 * @param x2_
	 *            Wspó³rzêdna X punktu nr 2.
	 * @param y2_
	 *            Wspó³rzêdna Y punktu nr 2.
	 * @return
	 */
	static public double angle(final int x1_, final int y1_, final int x2_,
			final int y2_) {
		double distance = distance(x1_, y1_, x2_, y2_);
		if (distance <= 0F) {
			System.err.println("B³êdne wspó³rzêdne - angle()");
			return 0;
		}
		double angle = (Math.acos((y2_ - y1_) / distance) * 180 / Math.PI);
		if (x2_ < x1_)
			angle = 360 - angle;
		return angle;
	}

	/**
	 * Metoda informuje czy podany String jest liczb¹ typu Int.<br>
	 * 
	 * @param num_
	 *            String
	 * @return true jeœli liczba, false jeœli String pusty lub nie stanowi
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
