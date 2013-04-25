package server;

/**
 * Enum prezentujący nazwę karty. Dla Wild Jack kartą cofająca jest wino(spade).<br>
 * ♠ spade ♥ heart ♦ diamond ♣ club
 * 
 * @author Misiek
 * @date 25.04.13
 */
public enum COLOR {
	Clubs(1), Diamonds(2), Hearths(3), Spades(4);
	private final int value;

	private COLOR(int x) {
		value = x;
	}

	public int getInt() {
		return value;
	}
}