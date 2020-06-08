package book;

public class MutableString {
	private static int DEFAULT_SIZE=10;
	
	private char[] charArray;
	
	private int length;
	
	public int getLength() {
		return length;
	}
	public int getCapacity() {
		return charArray.length;
	}
	
	public String toString() {
		return new String(charArray,0,length);
	}
	
	
	
	
	public MutableString() {
		charArray=new char[DEFAULT_SIZE];
		length=0;
	}
	
	
	public MutableString(char[] charArray) {
		this();
		if(getCapacity()<charArray.length)
			growArray(charArray.length*2+2);
		for(int i=0;i<charArray.length;i++) {
			this.charArray[i]=charArray[i];
			
		}
		length=charArray.length;
		System.out.printf("%s length %d capacity %d%n", new String(charArray,0,length),length,getCapacity());
	}
	
	public MutableString insert(int index,char c) {
		if(length+1> getCapacity()) {
			growArray((length+1)*2+2);
		}
		for(int i=length;i>index;i--) {
			charArray[i]=charArray[i-1];
		}
		charArray[index]=c;
		length++;
		return this;
	}
	
	public MutableString deleteCharAt(int index) {
		if(index>=length|| index<0) {
			throw new StringIndexOutOfBoundsException("String index out of range:"+index);}
		for(int i=index; i<length-1;i++) {
			charArray[i]=charArray[i+1];
		}
		length--;
		return this;
	}
	
	public MutableString append(MutableString str) {
		if(str.length+length>getCapacity()) {
			growArray((str.length+length)*2+2);
		}
		for(int i=0;i<str.charArray.length;i++) {
			this.charArray[length+i]=str.charArray[i];
			}
		length+=str.length;
		return this;
	}
	
	private void growArray(int newCapacity) {
		char[] newArray=new char[newCapacity];
		for(int i=0;i<length;i++) {
			newArray[i]=charArray[i];
		}
		charArray=newArray;
		System.out.printf("grow: %s length %d capacity %d%n", new String(charArray,0,length),length,getCapacity());
	}
	
}
