package lab5;

public class Necklace {

	private String representation;
	private DynamicProgrammingCache cache;
	public Necklace(String randomNecklace) {
		representation = randomNecklace;
	}
	public String getRepresentation() {
		return representation;
	}
	public void setCache(DynamicProgrammingCache cache) {
		this.cache = cache;
	}
	
	public int appraisal() {
		return cache.getMaxValue();
	}
	public String[] getBestElements() {
		return cache.getBestElements();
	}
}
