package lab5;

import java.util.HashMap;
import java.util.Map;

public class NecklaceAlgorithm {
	public enum SelectedValue {SIMPLE, DEFAULT};
	
	private Necklace necklace;
	
	public NecklaceAlgorithm(Necklace necklace) {
		this.necklace = necklace;
	}
	
	public void run(SelectedValue invokationType) {
//		System.out.println("Executing algorithm for the necklace: " + necklace.getRepresentation() + " (" + invokationType + ")");
		HashMap<String, Integer> rows_value = null;
		switch (invokationType) {
			case SIMPLE:
				rows_value = NecklaceFactory.getSimpleValuesTable();
				break;
		
			case DEFAULT:
				rows_value = NecklaceFactory.getDefaultValuesTable();
				break;
		}
		auxRun(rows_value);
	}
	
	public void run(String filename) {
//		System.out.println("Executing algorithm for the necklace: " + necklace.getRepresentation() + "(FILE)");
		HashMap<String, Integer> rows_value = NecklaceFactory.getValuesTable(filename);
		auxRun(rows_value);
	}
	
	private void auxRun(HashMap<String, Integer> rows_value) {
		String[] labels = new String[rows_value.keySet().size()];
		int[] values = new int[rows_value.keySet().size()];
		
		int index = 0;
		for(Map.Entry<String, Integer> entry : rows_value.entrySet()) {
			values[index] = entry.getValue();
			index++;
		}
		
		int[] weights = new int[necklace.getRepresentation().length()];
		
		for(int i = 0; i < weights.length; i++)
			weights[i] = i + 1;
		NecklaceCache cache = new NecklaceCache(rows_value.keySet().toArray(labels), values, weights, necklace.getRepresentation().length(), necklace.getRepresentation());
		necklace.setCache(cache);
		int appraisal = necklace.appraisal();
//		System.out.println("Appraisal: " + appraisal);
		String[] bestElements = necklace.getBestElements();
//		System.out.print("Best elements: ");
		Show(bestElements);
	}

	private void Show(String[] bestElements) {
		for(int i = 0; i < bestElements.length; i++) {
//			System.out.print(bestElements[i] + " ");
		}
//		System.out.println();
//		System.out.println();
	}
}