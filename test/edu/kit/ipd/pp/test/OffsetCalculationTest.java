package edu.kit.ipd.pp.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import edu.kit.ipd.pp.Memory.MemoryLayout;

public class OffsetCalculationTest {
	
	@Test
	public void testDefaultAlignment() {
		MemoryLayout mem = new MemoryLayout(16);
		int actual = mem.getAlignment(13);
		assertThat(actual, is(16));
	}

	@Test
	public void testMonteCarlo() {
		MemoryLayout instance = new MemoryLayout(16);

		for (int i = 0; i < 100000000; i++) {
			int randomOffset = Math.round((float) Math.random() * 100);

			int defWay = instance.getAlignment(randomOffset);
			int altWay = instance.getAltAlignment(randomOffset);
			int ourWay = instance.getFloAlignment(randomOffset);

			//System.out.println(String.format("%d, %d, %d, %d", randomOffset, defWay, altWay, ourWay));

			boolean allTheSame = (defWay == altWay) && (altWay == ourWay);

			assertTrue(allTheSame);
		}
	}

}
