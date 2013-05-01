package server;

/**
 * Enum prezentujący nazwę karty. Dla Wild Jack kartą cofająca jest wino(spade).<br>
 * ♣ club ♠ spade ♥ heart ♦ diamond
 * 
 * @author Misiek
 * @date 27.04.13
 */
public enum COLOR {
	Clubs(1), Spades(2), Hearths(3), Diamonds(4);
	private final int value;

	private COLOR(int x) {
		value = x;
	}

	public int getInt() {
		return value;
	}
}