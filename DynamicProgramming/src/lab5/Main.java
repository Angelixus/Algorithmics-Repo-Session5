package lab5;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Necklace necklace = new Necklace("RDDRR");
		HashMap<String, Integer> rows_value = NecklaceFactory.getSimpleValuesTable();
		String[] labels = new String[rows_value.keySet().size()];
		int[] values = new int[rows_value.keySet().size()];
		
		int index = 0;
		for(Map.Entry<String, Integer> entry : rows_value.entrySet()) {
			values[index] = entry.getValue();
			index++;
		}
		
		int[] weights = new int[necklace.getRepresentation().length() - 1];
		
		for(int i = 0; i < weights.length; i++)
			weights[i] = i + 1;
		DynamicProgrammingCache cache = new NecklaceCache(rows_value.keySet().toArray(labels), values, weights, necklace.getRepresentation().length(), necklace.getRepresentation());
		cache.updateTable();
		necklace.setCache(cache);
		System.out.println(necklace.appraisal());
		String[] bestElements = necklace.getBestElements();
		Show(bestElements);

		Necklace necklace2 = new Necklace("DDRRD");
		DynamicProgrammingCache cache2 = new NecklaceCache(new String[] {"DD","D","RD","RR"}, new int[] {2,3,7,1}, new int[] {1,2,3,4,5}, necklace2.getRepresentation().length(), necklace2.getRepresentation());
		cache2.updateTable();
		necklace2.setCache(cache2);
		System.out.println(necklace2.appraisal());
		String[] bestElements2 = necklace2.getBestElements();
		Show(bestElements2);
		
	}

	private static void Show(String[] bestElements) {
		for(int i = 0; i < bestElements.length; i++)
			System.out.print(bestElements[i] + " ");
		System.out.println();
	}
}