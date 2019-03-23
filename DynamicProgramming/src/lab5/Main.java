package lab5;

import lab5.NecklaceAlgorithm.SelectedValue;

public class Main {

	public static void main(String[] args) {
		// Hardcoded Necklaces
		Necklace necklace = new Necklace("RDDRR");
		NecklaceAlgorithm n1 = new NecklaceAlgorithm(necklace);
		n1.run(SelectedValue.SIMPLE);
		n1.run(SelectedValue.DEFAULT);
		
		Necklace necklace2 = new Necklace("DDRRD");
		NecklaceAlgorithm n2 = new NecklaceAlgorithm(necklace2);
		n2.run(SelectedValue.SIMPLE);
		n2.run(SelectedValue.DEFAULT);
	
		// Using NecklaceFactory
		// Length 2
		Necklace necklace3 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n3 = new NecklaceAlgorithm(necklace3);
		n3.run(SelectedValue.SIMPLE);
		n3.run(SelectedValue.DEFAULT);
		
		// Length 3
		Necklace necklace4 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n4 = new NecklaceAlgorithm(necklace4);
		n4.run(SelectedValue.SIMPLE);
		n4.run(SelectedValue.DEFAULT);
		
		// Length 4
		Necklace necklace5 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n5 = new NecklaceAlgorithm(necklace5);
		n5.run(SelectedValue.SIMPLE);
		n5.run(SelectedValue.DEFAULT);
		
		// Length 5
		Necklace necklace6 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n6 = new NecklaceAlgorithm(necklace6);
		n6.run(SelectedValue.SIMPLE);
		n6.run(SelectedValue.DEFAULT);
	}
}