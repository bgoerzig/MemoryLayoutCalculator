package Memory;

public class MemoryLayout {
	public final int alignment;

	public MemoryLayout(int alignment) {
		this.alignment = alignment;
	}
	
	public int getAlignment(int offset){
		if(offset % this.alignment == 0)
			return offset;
		return ((offset / this.alignment) + 1) * this.alignment;
	}

	public int getAltAlignment(int offset, int alignment){
		return (offset + this.alignment - 1) / this.alignment * this.alignment;
	}

	public int getFloAlignment(int offset, int alignment){
		return offset + (alignment - (offset % alignment));
	}
}
