package com.moulik.inheritence;

public class FinalDemo {

	public static void main(String[] args) {

	}

}
final class M {
	final double PI = 3.14;
	public M() {
		//PI = "1231"; This will not work because a final variable can not change value once it is assigned.
	}
	public final void show() {
		
	}
}
//class N extends M { This will not work because a final class cannot be extended.
	 //public void show() {  This will not work because final method cannot be overriden.

	 //}
//}
