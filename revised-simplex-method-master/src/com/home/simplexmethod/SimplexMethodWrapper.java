package com.home.simplexmethod;

public class SimplexMethodWrapper {
	private MainWindow main;
	SimplexMethodWrapper(MainWindow main)
	{
		this.main = main;
	}
	static {
		System.loadLibrary("simplex");
	}
	public native void startWork();
	public void callback(String message) {
	    System.out.println(message);
	}
	public void doneCallback(String message) {
		System.out.println(message);
		main.showNotification(message);
	}
	public void sizeOfResult(String size) {
		
	}
}
