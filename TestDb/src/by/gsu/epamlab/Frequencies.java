package by.gsu.epamlab;

public class Frequencies {
	private final int len;
	private final int num;
	
	public Frequencies(int len, int num) {
		this.len = len;
		this.num = num;
	}

	public int getLen() {
		return len;
	}

	
	public int getNum() {
		return num;
	}

	
	@Override
	public String toString() {
		return len + ";" + num;
	}
	
	
	
}
