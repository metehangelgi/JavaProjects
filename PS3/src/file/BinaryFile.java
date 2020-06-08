package file;

public abstract class BinaryFile extends File {

	private boolean canCopy;

	public BinaryFile(String name, long size, boolean canCopy) {
		super(size, name);
		this.canCopy = canCopy;

	}

	public boolean getCanCopy() {
		return this.canCopy;
	}

	public abstract BinaryFile getCopy() throws IllegalArgumentException;

	@Override
	public String toString() {
		return super.toString() + "Can copy = " + (canCopy ? "It can copy " : "It can't copy") + "\n";
	}

}
