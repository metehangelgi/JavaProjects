package store;

public class Ebook extends Book{
	
	private double fileSize;
	private String encodingFormat;
	private int numDevicesAllowed;
	private int numDevicesBeingUsed;
	private final int defNumDevicesBeingUsed=0;
	
	
	public Ebook() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public Ebook(String name, double price, String bookId,double fileSize,String encodingFormat,int numDevicesAllowed) {
		super(name, price, bookId);
		this.fileSize=fileSize;
		this.encodingFormat=encodingFormat;
		this.numDevicesAllowed=numDevicesAllowed;
		
		
		this.numDevicesBeingUsed = 0; 
		
		// TODO Auto-generated constructor stub
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize =  (fileSize>0) ? fileSize : 1.0;
	}

	public String getEncodingFormat() {
		return this.encodingFormat;
	}

	public void setEncodingFormat(String encodingFormat) {
		this.encodingFormat = encodingFormat;
	}

	public int getNumDevicesAllowed() {
		return numDevicesAllowed;
	}

	public void setNumDevicesAllowed(int numDevicesAllowed) {
		this.numDevicesAllowed = (numDevicesAllowed>0) ? numDevicesAllowed:1;
	}

	public int getNumDevicesBeingUsed() {
		return numDevicesBeingUsed;
	}

	public boolean addDevice() {
		
		if (numDevicesBeingUsed == numDevicesAllowed) {
			// exceeds the limit of the number of devices allowed
			return false;
		}
		this.numDevicesBeingUsed++;
		return true;
	}
	public boolean removeDevice() {
		if (numDevicesBeingUsed == 0) {
			// there are no devices to remove
			return false;
		}
		this.numDevicesBeingUsed--;
		return true;
	}
	
	public String toString() {
		return String.format("%s%n%f FileSize: %f%nEncodingFromat: %s%nnumDevicesAllowed: %d%n ", 
				super.toString(),this.fileSize,this.encodingFormat,this.numDevicesAllowed);
	}
//	public String toString() {
//		String res = super.toString() +
//		    "Book file size: " + this.getFileSize() + "\n" +
//			"Number of devices the book is allowed on: " + 
//		    this.getNumDevicesAllowed() + "\n" +
//			"Number of devices the book is being used on: " + 
//		    this.getNumDevicesBeingUsed() + "\n";
//		return res;
//	}
	
	
}
