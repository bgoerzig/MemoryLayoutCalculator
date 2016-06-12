package edu.kit.ipd.pp.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.kit.ipd.pp.Memory.MemoryLayout;

public class OffsetCalculationTest {

	private static final int ALIGNMENT = 8;
	private static final int OFFSET_GT = 14;
	private static final int OFFSET_EQ = 8;

	private static MemoryLayout mem;

	@BeforeClass
	public static void setupBeforClass(){
		mem = new MemoryLayout(ALIGNMENT);
	}

	@Test
	public void testDefaultAlignmentGT() {
		int alignment = mem.getAlignment(OFFSET_GT);
		final int EXPECTED = 16;
		assertThat(alignment, is(EXPECTED));
	}

	@Test
	public void testAltAlignmentGT() {
		int alignment = mem.getAltAlignment(OFFSET_GT);
		final int EXPECTED = 16;
		assertThat(alignment, is(EXPECTED));
	}

	@Test
	public void testFloAlignmentGT() {
		int alignment = mem.getFloAlignment(OFFSET_GT);
		final int EXPECTED = 16;
		assertThat(alignment, is(EXPECTED));
	}

	@Test
	public void testAlignmentEQ() {
		int alignment = mem.getAlignment(OFFSET_EQ);
		final int EXPECTED = 8;
		assertThat(alignment, is(EXPECTED));
	}

	@Test
	public void testAltAlignmentEQ() {
		int alignment = mem.getAltAlignment(OFFSET_EQ);
		final int EXPECTED = 8;
		assertThat(alignment, is(EXPECTED));
	}

	@Test
	public void testFloAlignmentEQ() {
		int alignment = mem.getFloAlignment(OFFSET_EQ);
		final int EXPECTED = 8;
		assertThat(alignment, is(EXPECTED));
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
