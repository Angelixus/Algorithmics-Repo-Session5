package lab5;

public class NecklaceCache extends DynamicProgrammingCache {
	
	private Necklace necklace;
	
	public NecklaceCache(String[] labels, int[] values, int[] weights, int max, Necklace necklace) {
		super(labels, values, weights, max);
		this.necklace = necklace;
	}

	@Override
	protected void updateCell(int i, int j) {
		int leftValue = defaultValueForCell(i, j);
		boolean canApplyRule = checkSubstring(j, objectLabels[i]);
		
		// The rule cannot be applied
		if(!canApplyRule) {
			cache[i][j] = leftValue;
		}
		// The rule can be applied
		else {
			int rightValue = objectValues[i] + cache[objectLabels.length - 1][j - objectLabels[i].length()];
			cache[i][j] = Math.max(leftValue, rightValue);
		}
	}

	private boolean checkSubstring(int j, String string) {
		String subNecklace = necklace.getSubstring(j + 1);
		return subNecklace.contains(subNecklace);
	}

	@Override
	protected int defaultValueForCell(int i, int j) {
		if(j == 0)
			return 0;
		return cache[i][j - 1];
	}

	@Override
	public String[] getBestElements() {
		return null;
	}

}
