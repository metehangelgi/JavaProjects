package aaaa;

final class B extends A {
    private int var1;
    B() {
       super();
       setVar1(20);
       var1 = 30;
       var2 = 40;
    }
    public String toString() {
      return String.format("Super %s %n B: %d %d %d%n",super.toString(),var1,var2,count);
    }
}
