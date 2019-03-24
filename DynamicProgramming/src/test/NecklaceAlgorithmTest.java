package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import lab5.Necklace;
import lab5.NecklaceFactory;

class NecklaceAlgorithmTest {

	@Test
	void test1() {
		String necklace = "RDDRR";
		HashMap<String, Integer> rows_value = NecklaceFactory.getSimpleValuesTable();
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
		assertEquals(16, cache.appraisal());
		assertArrayEquals(new String[] {"R", "DDR", "R"}, cache.getBestElements());
	}
	
	@Test
	void test2() {
		String necklace = "SSERDRSSEERDRRSRSERRRDEEDSDDSSDRSRDRREERDSERRSSRSRSSSERRRERRRESSDESEERRDRRRRRDDRRERRDSSSESRDRRSSDEESRSRSRRDDDDSSRSERSDDRRDEDDDEESSDSSEERDDRERSRRESRDSSERESRDRRRSESDRDDSEERSEDRDEESDSEDRSDRDDDSSERDSDESSDDSRDESRDDDSEREDESDERDRRDDSSDSDDDRERSSSSRDRDERERSSSSEDERERESRRRERDRSRSDEESDSDSREDDSESDRDRDDERSDEDRDEESSEDEEERSSRREEDDEEEEDDERSDRSSREDDDEEDSSDREESSRSRDRRRSDRERERSDEEERRRRSDRERSEERSDESDERSDREDEDSRDEDEDRESEDRSRDRESRRDDEDDSRSSSERERDSDRRRERERDEEDRREDDDRRSSRSESERREDSEESEERREDESEDRDDRSSDRSRDDRDRERRDREDESDSSERSERRSEESDSDRSSDEDDSDSRSSDERRRSRDRRRRDDSEDSDDERRDRSEESRDDSESSDREEEDEDEEDSRESSRESSRRDESRDSRRSSEDSSRSREDDDESEESRESDEEREEDESRSRSSSDDSDSDESDSEESSDSEDESSERRSERSRRESSDSDSDDRSSSERDEDSDREESSSSDDSEDEEDRRSRDDSSERREESSEERESDESRSDESRDEEEDDDDREDDDSRDRDRDRSEEDDESSSDDSRSESSDSDSREESDRDDDDRESDRESEDRDDERERESDESEEDDDSRRDSERSSEDDEDEDSEERSERDRDRDRSRDERDDDDSEDRDSDSDESEREESSRDRSSRRSSDEDERSDDDDDDRDRDESSRRRDRDEDRESEDRSDSERRRSESEEEEESESSRSSRDEESESSRRRRRDSSSEDRRDREDRDESDSDRRDRSSESDEDSESSDRDSSRRSERRRRDSESEDERDERSDREREDEDE";
		HashMap<String, Integer> rows_value = NecklaceFactory.getDefaultValuesTable();
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
		assertEquals(38963, cache.appraisal());
		String[] arrayToTest = "SS, E, R, D, R, SS, EE, R, D, RR, S, R, S, E, RRR, D, EE, DSD, D, SS, D, R, S, R, D, RR, EE, R, D, S, E, RR, SS, R, S, R, SSS, E, RRR, E, RRR, E, SS, D, E, S, EE, RR, D, RRR, RR, DD, RR, E, RR, D, SSS, E, S, R, D, RR, SS, D, EE, S, R, S, R, S, RR, DDD, D, SS, R, S, E, R, S, DD, RR, D, E, DDD, EE, SS, D, SS, EE, R, DD, R, E, R, S, RR, E, S, R, D, SS, E, R, E, S, R, D, RRR, S, E, S, DRD, D, S, EE, R, S, E, DRD, EE, S, D, S, E, D, R, S, D, R, DDD, SS, E, R, DSD, E, SS, DD, S, R, D, E, S, R, DDD, S, E, R, E, D, E, S, D, E, R, D, RR, DD, SS, D, S, DDD, R, E, R, S, SSS, R, DRD, E, R, E, R, S, SSS, E, D, E, R, E, R, E, S, RRR, E, R, D, R, S, R, S, D, EE, S, DSD, S, R, E, DD, S, E, S, DRD, R, DD, E, R, S, DED, R, D, EE, SS, E, D, EEE, R, SS, RR, EE, DD, E, EEE, DD, E, R, S, D, R, SS, R, E, DDD, EE, D, SS, D, R, EE, SS, R, S, R, D, RRR, S, D, R, E, R, E, R, S, D, EEE, RRR, R, S, D, R, E, R, S, EE, R, S, D, E, S, D, E, R, S, D, R, E, DED, S, R, D, E, DED, R, E, S, E, D, R, S, R, D, R, E, S, RR, DD, E, DD, S, R, SSS, E, R, E, R, DSD, RRR, E, R, E, R, D, EE, D, RR, E, DDD, RR, SS, R, S, E, S, E, RR, E, D, S, EE, S, EE, RR, E, D, E, S, E, DRD, D, R, SS, D, R, S, R, D, DRD, R, E, RR, D, R, E, D, E, S, D, SS, E, R, S, E, RR, S, EE, S, DSD, R, SS, DED, DSD, S, R, SS, D, E, RRR, S, R, D, RRR, R, DD, S, E, DSD, D, E, RR, D, R, S, EE, S, R, DD, S, E, SS, D, R, EE, EDEDE, E, D, S, R, E, SS, R, E, SS, RR, D, E, S, R, D, S, RR, SS, E, D, SS, R, S, R, E, DDD, E, S, EE, S, R, E, S, D, EE, R, EE, D, E, S, R, S, R, SSS, DD, S, DSD, E, S, D, S, EE, SS, D, S, E, D, E, SS, E, RR, S, E, R, S, RR, E, SS, DSD, S, DD, R, SSS, E, R, DED, S, D, R, EE, S, SSS, DD, S, E, D, EE, D, RR, S, R, DD, SS, E, RR, EE, SS, EE, R, E, S, D, E, S, R, S, D, E, S, R, D, EEE, DDD, D, R, E, DDD, S, R, DRD, R, D, R, S, EE, DD, E, SSS, DD, S, R, S, E, SS, DSD, S, R, EE, S, D, R, DDD, DRESDRES, E, DRD, D, E, R, E, R, E, S, D, E, S, EE, DDD, S, RR, D, S, E, R, SS, E, DD, E, DED, S, EE, R, S, E, R, DRD, R, D, R, S, R, D, E, R, DDD, D, S, E, DRD, S, DSD, E, S, E, R, EE, SS, R, D, R, SS, RR, SS, DED, E, R, S, DDD, DDD, R, DRD, E, SS, RRR, D, R, DED, R, E, S, E, D, R, S, D, S, E, RRR, S, E, S, EEE, EE, S, E, SS, R, SS, R, D, EE, S, E, SS, RRR, RR, D, SSS, E, D, RR, D, R, E, DRD, E, S, DSD, RR, D, R, SS, E, S, DED, S, E, SS, DRD, SS, RR, S, E, RRR, R, D, S, E, S, E, D, E, R, D, E, R, S, D, R, E, R, EDEDE".split(", ");
		Collections.reverse(Arrays.asList(arrayToTest));
		assertArrayEquals(arrayToTest, cache.getBestElements());
	}
}
