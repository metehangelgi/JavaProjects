/*
 * File: Question2.java
 * ---------------------------
 * This program draws the reflection of image of half face of a person with respect to vertical line
 *
 */
import acm.graphics.*;
import acm.program.*;

public class Question2 extends GraphicsProgram{
	public void run() {
		GImage image = new GImage("HalfFaceImage.png");	
		add(image,0 ,0);
		//Your code starts here
		GImage mirroredImage=rightReflection(image);
		add(mirroredImage,image.getWidth(),0);
        //Your code ends here
		resize((int)image.getWidth() * 2 + 1, (int)image.getHeight());
	}
	//Creates the reflection of the image with respect to X=with of the image
	private GImage rightReflection(GImage image) {
		int[][] pixels = image.getPixelArray();
		
		// Your code start here
			int height=pixels.length;
			int width= pixels[0].length;
			
			for(int i=0;i<width/2;i++) {
				for(int j=0;j<height;j++) {
					int temp=pixels[j][i];
					pixels[j][i]=pixels[j][width-i-1];
					pixels[j][width-i-1]=temp;
				}
			}
			
			
			
//			int[][] finalpic=new int[pixels.length][pixels[0].length];
//			for(int j=0;j<pixels[0].length;j++) {
//				for(int i=0;i<pixels.length ;i++) {
//					int[] temparray=new int[pixels.length];
//					temparray[i]=pixels[j][i];
//				}
//				
//			}
			
		// Your code ends here
		return new GImage(pixels);				
	}		
	

}
