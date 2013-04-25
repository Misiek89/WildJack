package server;

/**
 * Klasa reprezentuj¹ca logiczn¹ kartê do gry.
 * 
 * @author Misiek
 * @date 25.04.13
 */
public class LogicCard implements Comparable<LogicCard> {
	private VALUE value;
	private COLOR color;

	public LogicCard(VALUE value_, COLOR color_) {
		if (value_ != null && color_ != null) {
			value = value_;
			color = color_;
		} else
			new IllegalArgumentException("Value:" + (value != null) + " Color:"
					+ (color != null));
	}

	public VALUE getValue() {
		return value;
	}

	public COLOR getColor() {
		return color;
	}

	public int compareTo(LogicCard o) {
		if (o != null) {
			if (this.getValue().compareTo(o.getValue()) == 0) {
				return this.getColor().getInt() - o.getColor().getInt();
			} else
				return this.getValue().getInt() - o.getValue().getInt();
		} else
			return 0;
	}

	public String toString() {
		return "LogicCard " + this.getValue() + " " + this.getColor();
	}
}
