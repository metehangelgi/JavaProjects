/*
 * (**) Implement the GFace class and try to have an output like the
 * given. GFace class is a extends to GCompound. Its constructor takes a
 * width and a height value. Head itself has that exact width and
 * height. Every other component of the face defined in terms of
 * percentages to either width or height (For example EYE_WIDTH = 0.15
 * means GOval you used for eye will be 15/100 of the given width. Same
 * for LEFT_EYE_ORIGIN_WIDTH = 0.25 which means that origin of the left
 * eye (center of the oval) will be at 1/4 of width, and so on). Nose is
 * an isosceles.
 */

import acm.program.*;

public class GFaces extends GraphicsProgram{

	public void run() {
		GFace left = new GFace(100, 100);
		left.setLocation(25, 75);
		add(left);
		GFace middle = new GFace(50, 150);
		middle.setLocation(150, 25);
		add(middle);
		GFace right = new GFace(100, 100);
		right.setLocation(225, 75);
		add(right);
	}
}
