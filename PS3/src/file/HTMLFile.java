package file;

import java.util.ArrayList;

public class HTMLFile extends TextFile implements Openable {

	private ExecutableFile browserCompatibleWith;
	private int htmlVersion;
	private ArrayList<HTMLFile> linksTo;

	public HTMLFile(String name, long size, String encoding, int htmlVersion, ExecutableFile browserCompatibleWith,
			ArrayList<HTMLFile> linksTo) {
		// default numChar =10000;
		super(name, size, encoding, 10000);
		this.htmlVersion = htmlVersion;
		this.linksTo = linksTo;
		this.browserCompatibleWith = browserCompatibleWith;
		this.linksTo = linksTo;
	}

	public int getHtmlVersion() {
		return htmlVersion;
	}

	public ExecutableFile getBrowserCompatibleWith() {
		return browserCompatibleWith;
	}

	public void setHtmlVersion(int htmlVersion) {
		this.htmlVersion = htmlVersion;
	}

	public ArrayList<HTMLFile> getLinksTo() {
		return linksTo;
	}

	public void setLinksTo(ArrayList<HTMLFile> linksTo) {
		this.linksTo = linksTo;
	}

	public String opensWith() {
		return this.browserCompatibleWith.getName();
	}

	@Override
	public void clear() {
		try {
			this.linksTo.clear();
		} catch (UnsupportedOperationException e) {
			throw new UnsupportedOperationException(e.getMessage());
		}
		this.browserCompatibleWith = new ExecutableFile("iexplore.exe", 200000, true, "Windows on Intel");
	}

	@Override
	public void onClick() {
		System.out.println("On click: " + this.opensWith() + " " + this.getName());
	}

	public String toString() {
		String res = "Type: HTML File \n" + super.toString();

		res += "Compatible with: " + this.browserCompatibleWith.getName() + "\n";
		res += "HTML version: " + this.htmlVersion + "\n";
		if (linksTo != null) {
			res += "Links to: ";
			for (File f : linksTo) {
				res += f.getName() + " ";

			}
		}
		return res + "\n";
	}

}
