package file;

public class DataFile extends BinaryFile implements Openable {

	private String compressionFormat;
	private ExecutableFile opensWith;

	public DataFile(String name, long size, boolean canCopy, String compressionFormat, ExecutableFile opensWith) {
		super(name, size, canCopy);
		this.compressionFormat = compressionFormat;
		this.opensWith = opensWith;
	}

	public String getCompressionFormat() {
		return compressionFormat;
	}

	public void setCompressionFormat(String compressionFormat) {
		this.compressionFormat = compressionFormat;
	}

	public ExecutableFile getOpensWith() {
		return opensWith;
	}

	public void setOpensWith(ExecutableFile opensWith) {
		this.opensWith = opensWith;
	}
	
	
	

	@Override
	public BinaryFile getCopy() throws IllegalArgumentException{
		DataFile newInstance=null;
		
		if(this.getCanCopy()) {
			String newName=this.getName();
			if(newName.contains(".")) {
				int extensionIndex= newName.indexOf(".");
				newName=newName.substring(0,extensionIndex).concat("(copy)").concat(newName.substring(extensionIndex));
			} else 
				newName+="(copy)";
			
			newInstance = new DataFile(newName, this.getSize(), this.getCanCopy(), new String(this.compressionFormat), this.opensWith);
		} else
			throw new IllegalArgumentException("You cannot make a copy of this file due to the copyright law!");
			
		return newInstance;
	}

	@Override
	public void onClick() {
		System.out.println("On click: " +this.opensWith() + " " + this.getName());

	}

	public String opensWith() {
		return opensWith.getName();
	}

	public String toString() {
		String res = super.toString() + "\n";
		res += "compressionFormat: " + getCompressionFormat();
		return res;

	}

}
