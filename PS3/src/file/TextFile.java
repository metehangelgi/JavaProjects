package file;

public abstract class TextFile extends File {

	private String encoding;
	private long numChars;

	public TextFile(String name, long size, String encoding, long numChars) {
		super(size, name);
		this.encoding = encoding;
		this.numChars = numChars;

	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public long getNumChars() {
		return numChars;
	}

	public void setNumChars(long numChars) {
		this.numChars = numChars;
	}

	public abstract void clear();

	public String toString() {
		String printer = "name: " + getName();
		printer += "size: " + getSize();
		printer += "encoding: " + getEncoding();
		printer += "numChars: " + getNumChars();

		return printer;

		// ("name: %s%n size: %f%n encoding: %s%n numChars: %f%n",
		// getName(), getSize(),getEncoding(),getNumChars());

	}

}
