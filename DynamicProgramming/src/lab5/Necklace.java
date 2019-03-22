package lab5;

public class Necklace {

	private String representation;
	public Necklace(String randomNecklace) {
		representation = randomNecklace;
	}
	public String getSubstring(int j) {
		return representation.substring(1, j);
	}

}
