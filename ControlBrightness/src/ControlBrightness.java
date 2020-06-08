import acm.graphics.GImage;
import acm.program.GraphicsProgram;


public class ControlBrightness extends GraphicsProgram{
	public void run(){
		GImage mainImage = new GImage("shellFish_s.png");
		GImage darkerImage=brightenImage(mainImage,0.5);
		GImage brigterImage=brightenImage(mainImage,1.5);
		add(darkerImage);
		add(mainImage,0,mainImage.getHeight());
		add(brigterImage,0,2*mainImage.getHeight());
		setSize((int)mainImage.getWidth(),(int)(3*mainImage.getHeight()));
	}
	private GImage brightenImage(GImage image,double factor){
		//creating color matrix
		int[][] array=image.getPixelArray();
		//creating individual color matrices
		int[][] red=new int[array.length][array[0].length];
		int[][] green=new int[array.length][array[0].length];
		int[][] blue=new int[array.length][array[0].length];
		//decompose into colors
		decomposeColors(array,red,green,blue);
		//perform brightness modification on each color
		adjustBrightness(red,factor);
		adjustBrightness(green,factor);
		adjustBrightness(blue,factor);
		//recompose int array
		recompose(array,red,green,blue);
		return new GImage(array);
	}
	private void decomposeColors(int[][] array,int[][] red,int[][] green,int[][] blue){
		//Your code starts here
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				int pixel = array[i][j];
				red[i][j] = GImage.getRed(pixel);
				green[i][j] = GImage.getGreen(pixel);
				blue[i][j] = GImage.getBlue(pixel);
			}
		}
		//Your code ends here
	}
	private void recompose(int[][] array,int[][] red,int[][] green,int[][] blue){
		//Your code starts here
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				array[i][j]=GImage.createRGBPixel(red[i][j],green[i][j],blue[i][j]);
			}
		}
		//Your code ends here
	}
	private void adjustBrightness(int[][] colorArray,double factor){
		//Your code starts here
		for(int i=0;i<colorArray.length;i++){
			for(int j=0;j<colorArray[0].length;j++){
				double newVal=colorArray[i][j]*factor;
				if(newVal>255){//if the value exceeds the color limit assign to the max value
					newVal=255.0;
				}
				colorArray[i][j]=(int) newVal;
			}
		}
		//Your code ends here
	}
}
