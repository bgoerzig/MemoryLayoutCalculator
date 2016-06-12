package edu.kit.ipd.pp;

import java.util.logging.Level;
import java.util.logging.Logger;

import Memory.MemoryLayout;

public class OffsetCalculator {
	private static final Logger LOG = Logger.getLogger( OffsetCalculator.class.getName() );
	private static final Level LEVEL = Level.INFO;
	
	public static void main (String args[]){
		MemoryLayout mem = new MemoryLayout(3);
		LOG.log(LEVEL, String.valueOf(mem.getAlignment(13)));
	}
}
