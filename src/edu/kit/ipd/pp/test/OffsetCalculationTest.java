package edu.kit.ipd.pp.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;

import static org.hamcrest.CoreMatchers.is;

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

}
