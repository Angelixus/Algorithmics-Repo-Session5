package lab5;

import java.util.HashMap;
import java.util.Map;

public class NecklaceAlgorithm {
	public enum SelectedValue {SIMPLE, DEFAULT};
	
	private String necklace;
	
	public NecklaceAlgorithm(String necklace) {
		this.necklace = necklace;
	}
	
	public void run(SelectedValue invokationType) {
		System.out.println("Executing algorithm for the necklace: " + necklace + " (" + invokationType + ")");
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
	
	public void runNoPrint(SelectedValue invokationType) {
		HashMap<String, Integer> rows_value = null;
		switch (invokationType) {
			case SIMPLE:
				rows_value = NecklaceFactory.getSimpleValuesTable();
				break;
		
			case DEFAULT:
				rows_value = NecklaceFactory.getDefaultValuesTable();
				break;
		}
		auxRunNoPrint(rows_value);
	}
	
	private void auxRunNoPrint(HashMap<String, Integer> rows_value) {
		String[] labels = new String[rows_value.keySet().size()];
		int[] values = new int[rows_value.keySet().size()];
		
		int index = 0;
		for(Map.Entry<String, Integer> entry : rows_value.entrySet()) {
			values[index] = entry.getValue();
			index++;
		}
		
		int[] weights = new int[necklace.length()];
		
		for(int i = 0; i < weights.length; i++)
			weights[i] = i + 1;
		Necklace cache = new Necklace(rows_value.keySet().toArray(labels), values, weights, necklace.length(), necklace);
		cache.appraisal();
		cache.getBestElements();
	}

	public void run(String filename) {
		System.out.println("Executing algorithm for the necklace: " + necklace + " (FILE)");
		HashMap<String, Integer> rows_value = NecklaceFactory.getValuesTable(filename);
		auxRun(rows_value);
	}
	
	public void run(HashMap<String, Integer> rows_value) {
		System.out.println("Executing algorithm for the necklace: " + necklace + " (CUSTOM_VALUES)");
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
		
		int[] weights = new int[necklace.length()];
		
		for(int i = 0; i < weights.length; i++)
			weights[i] = i + 1;
		Necklace cache = new Necklace(rows_value.keySet().toArray(labels), values, weights, necklace.length(), necklace);
		int appraisal = cache.appraisal();
		System.out.println("Appraisal: " + appraisal);
		String[] bestElements = cache.getBestElements();
		System.out.print("Best elements: ");
		Show(bestElements);
	}

	private void Show(String[] bestElements) {
		for(int i = 0; i < bestElements.length; i++) {
			System.out.print(bestElements[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
}