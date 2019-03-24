package lab5;

import java.util.HashMap;

import lab5.NecklaceAlgorithm.SelectedValue;

public class Main {

	public static void main(String[] args) {
		// Hardcoded Necklaces
		NecklaceAlgorithm n1 = new NecklaceAlgorithm("RDDRR");
		n1.run(SelectedValue.SIMPLE);
		n1.run(SelectedValue.DEFAULT);

		NecklaceAlgorithm n2 = new NecklaceAlgorithm("DDRRD");
		n2.run(SelectedValue.SIMPLE);
		n2.run(SelectedValue.DEFAULT);

		HashMap<String, Integer> rows_values = new HashMap<>();
		rows_values.put("DD", 2);
		rows_values.put("D", 3);
		rows_values.put("RD", 7);
		rows_values.put("RR", 1);
		n2.run(rows_values);

		NecklaceAlgorithm nAux = new NecklaceAlgorithm("SSERDRSSEERDRRSRSERRRDEEDSDDSSDRSRDRREERDSERRSSRSRSSSERRRERRRESSDESEERRDRRRRRDDRRERRDSSSESRDRRSSDEESRSRSRRDDDDSSRSERSDDRRDEDDDEESSDSSEERDDRERSRRESRDSSERESRDRRRSESDRDDSEERSEDRDEESDSEDRSDRDDDSSERDSDESSDDSRDESRDDDSEREDESDERDRRDDSSDSDDDRERSSSSRDRDERERSSSSEDERERESRRRERDRSRSDEESDSDSREDDSESDRDRDDERSDEDRDEESSEDEEERSSRREEDDEEEEDDERSDRSSREDDDEEDSSDREESSRSRDRRRSDRERERSDEEERRRRSDRERSEERSDESDERSDREDEDSRDEDEDRESEDRSRDRESRRDDEDDSRSSSERERDSDRRRERERDEEDRREDDDRRSSRSESERREDSEESEERREDESEDRDDRSSDRSRDDRDRERRDREDESDSSERSERRSEESDSDRSSDEDDSDSRSSDERRRSRDRRRRDDSEDSDDERRDRSEESRDDSESSDREEEDEDEEDSRESSRESSRRDESRDSRRSSEDSSRSREDDDESEESRESDEEREEDESRSRSSSDDSDSDESDSEESSDSEDESSERRSERSRRESSDSDSDDRSSSERDEDSDREESSSSDDSEDEEDRRSRDDSSERREESSEERESDESRSDESRDEEEDDDDREDDDSRDRDRDRSEEDDESSSDDSRSESSDSDSREESDRDDDDRESDRESEDRDDERERESDESEEDDDSRRDSERSSEDDEDEDSEERSERDRDRDRSRDERDDDDSEDRDSDSDESEREESSRDRSSRRSSDEDERSDDDDDDRDRDESSRRRDRDEDRESEDRSDSERRRSESEEEEESESSRSSRDEESESSRRRRRDSSSEDRRDREDRDESDSDRRDRSSESDEDSESSDRDSSRRSERRRRDSESEDERDERSDREREDEDE");
		nAux.run(SelectedValue.DEFAULT);

		// Using NecklaceFactory
		// Length 2
		String necklace3 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n3 = new NecklaceAlgorithm(necklace3);
		n3.run(SelectedValue.SIMPLE);
		n3.run(SelectedValue.DEFAULT);

		// Length 3
		String necklace4 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n4 = new NecklaceAlgorithm(necklace4);
		n4.run(SelectedValue.SIMPLE);
		n4.run(SelectedValue.DEFAULT);

		// Length 4
		String necklace5 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n5 = new NecklaceAlgorithm(necklace5);
		n5.run(SelectedValue.SIMPLE);
		n5.run(SelectedValue.DEFAULT);

		// Length 5
		String necklace6 = NecklaceFactory.createTwoPiecesNecklace(10);
		NecklaceAlgorithm n6 = new NecklaceAlgorithm(necklace6);
		n6.run(SelectedValue.SIMPLE);
		n6.run(SelectedValue.DEFAULT);
	}
}