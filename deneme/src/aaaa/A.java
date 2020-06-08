package aaaa;

public class A {
	static int count = 0; // extra question: if you flip these lines, output changes why?
	public final static B b = new B();
	
	

	private int var1;
	protected int var2;

	A() {
		var1 = 5;
		var2 = 10;
		count++;
	}

	public void setVar1(int var1) {
		this.var1 = var1;
	}

	public int getVar1() {
		return this.var1;
	}

	private void f() {
		System.out.println("in A f()");
	}

	protected void h() {
		f();
	}

	public String toString() {
		return String.format("A: %d %d %d%n", var1, var2, count);
	}

	public static void main(String argv[]) {
		A a1 = new A();
		System.out.println(a1);
		B b1 = new B();
		System.out.println(b1);

	}

}