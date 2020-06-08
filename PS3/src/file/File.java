package file;

public abstract class File {

	private long size;
	private String name;

	public File(long size, String name) {
		this.size = size;
		this.name = name;
	}

	public abstract void onClick();

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String fileName) {
		if (fileName.contains(" ")) {
			fileName = fileName.replace(" ", "");
		}
		this.name = fileName;
	}

	public String toString() {
		String res = "name: " + getName() + "\n";
		res += "size: " + getSize()+"\n";
		return res;
	}

	public static void callPolymorphicMethods(File[] files) {

		for (File file : files) {
			System.out.println("\nFile: " + file.getName());
			file.onClick();
			
			if(file instanceof Openable)
				System.out.println("Open with: " + ((Openable)file).opensWith());
			if(file instanceof TextFile)
				((TextFile)file).clear();
			else if(file instanceof BinaryFile) {
				try{
					BinaryFile cp = ((BinaryFile)file).getCopy();
					System.out.println("Copied. ");
					cp.onClick();
				} catch(IllegalArgumentException e) {
					System.out.println("IllegalArgumentException: " + e.getMessage());
				}
			}
		}

	}
}
