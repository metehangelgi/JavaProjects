package file;

public class PlainTextFile extends TextFile {

	private String[] lines;

	public PlainTextFile(String fName, long fSize, String encoding, String[] fileLines) {
		super(fName, fSize, encoding, getNumChars(fileLines));
		this.lines = fileLines;
	}

	public String[] getLines() {
		return lines;
	}

	public void setLines(String[] lines) {
		this.lines = lines;
	}

	private static long getNumChars(String[] fLines) {
		long res=0;
		for(int i=0; i<fLines.length; i++) {
			res += (long)fLines[i].length();
		}
		return res;
	}

	@Override
	public void clear() {
		lines = new String[10];
		for (String line : lines) {
			line = "";
		}

	}

	@Override
	public void onClick() {
		System.out.println("On click: ");
		for (String line : lines) {
			System.out.println(line);
		}

	}

	public String toString() {
		String res = super.toString() + "\n";
		for (String line : lines) {
			res += line + "\n";

		}
		return res;

	}

}
