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

}
