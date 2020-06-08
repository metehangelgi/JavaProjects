package file;

public class ExecutableFile extends BinaryFile {

	private String platform;

	public ExecutableFile(String name, long size, boolean canCopy, String platform) {

		super(name, size, canCopy);
		this.platform = platform;

	}
	
	

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatform() {

		return platform;
	}

	@Override
	public void onClick() {
		System.out.println("On click: " +getName());

	}
	
	
	public BinaryFile getCopy() throws IllegalArgumentException{
		ExecutableFile newInstance = null;

		if(this.getCanCopy()) {
			String newName=this.getName();
			if(newName.contains(".")) {
				int extensionIndex = newName.indexOf(".");
				newName = newName.substring(0, extensionIndex).concat("(copy)").
						concat(newName.substring(extensionIndex));
			} else 
				newName+="(copy)";
			
			newInstance = new ExecutableFile(newName, this.getSize(), this.getCanCopy(), new String(this.platform));
		} else 
			throw new IllegalArgumentException("You cannot make a copy of this file due to the copyright law!");
		
		return newInstance;
	}
		

	public String toString() {
		String res="Type: Executable File \n" +super.toString()+"\n";
		res+="platform: "+getPlatform()+"\n";
		return res;
	}
	
}
