package lab5;

import java.util.ArrayList;

public class NecklaceCache extends DynamicProgrammingCache {
	
	private String representation;
	
	public NecklaceCache(String[] labels, int[] values, int[] weights, int max, String representation) {
		super(labels, values, weights, max);
		this.representation = representation;
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
		int backtrackLimit = string.length();
		if(backtrackLimit > j)
			return false;
		String subNecklace = representation.substring(j - backtrackLimit, j);
		return subNecklace.contains(string);
	}

	@Override
	protected int defaultValueForCell(int i, int j) {
		if(j == 0)
			return 0;
		if(i == 0)
			return cache[cache.length - 1][j - 1];
		return cache[i - 1][j];
	}

	@Override
	public String[] getBestElements() {
		ArrayList<String> res = new ArrayList<>();
		int starti = cache.length - 1;
		int startj = cache[starti].length - 1;
		
		boolean changedValue = false;
		int lastAddedLength = 0;
		int lastJ = startj;
		for(int j = startj; j >= 0; j--) {
			for(int i = starti; i >= 0; i--) {
				
				if(lastJ - lastAddedLength < 0)
					break;
				
				if(i == 0) {
					if(j != 0) {
						changedValue = checkNumbers(cache[i][j], cache[cache.length - 1][j - 1]);
					}
					else
						break;
				}
				else {
					changedValue = checkNumbers(cache[i][j], cache[i - 1][j]);
				}
				
				if(changedValue && lastJ - lastAddedLength >= j) {
					res.add(objectLabels[i]);
					lastAddedLength = objectLabels[i].length();
					lastJ = j;
				}
			}
		}
		String[] resActual = new String[res.size()];
		return res.toArray(resActual);
	}

	private boolean checkNumbers(int n1, int n2) {
		return n1 != n2;
	}

}
