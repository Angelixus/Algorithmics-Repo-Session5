package lab5;
import lab5.NecklaceAlgorithm.SelectedValue;

public class NecklaceTimes {

	public static void main(String[] args) {

		SelectedValue[] ways = SelectedValue.values();
		for (int i1 = 0; i1 < ways.length; i1++) {
			SelectedValue choose = ways[i1];
			System.out.println("Starting test for the (" + choose + ") rules");
			System.out.println("----------------------------------------------");
			for (int type = 0; type < args.length; type++) {
				try {
					System.out.println("Times for a necklace with: " + Integer.parseInt(args[type]) + " pieces");
					System.out.println();
					for (int i = 10000; i < Integer.MAX_VALUE; i *= 2) {
						Necklace necklace = null;
						if (Integer.parseInt(args[type]) == 2)
							necklace = NecklaceFactory.createTwoPiecesNecklace(i);
						else if (Integer.parseInt(args[type]) == 3)
							necklace = NecklaceFactory.createThreePiecesNecklace(i);
						else if (Integer.parseInt(args[type]) == 4)
							necklace = NecklaceFactory.createFourPiecesNecklace(i);
						else
							necklace = NecklaceFactory.createFiveNecklace(i);

						NecklaceAlgorithm algorithm = new NecklaceAlgorithm(necklace);

						long start = System.currentTimeMillis();
						algorithm.run(choose);
						long end = System.currentTimeMillis();

						long elapsed = end - start;

						System.out.println("Elapsed time for n = " + i + ": " + elapsed);
					}
				} catch (OutOfMemoryError e) {
					System.out.println();
					continue;
				}
			}
		}
	}
}