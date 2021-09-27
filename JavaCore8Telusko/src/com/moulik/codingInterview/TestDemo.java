package com.moulik.codingInterview;

public class TestDemo {

	public static void main(String[] args) {

		String gfg[] = {"a","b","c","a","c"};
		for (int i=0; i< gfg.length; ++i ) {
			for (int j=i+1; j<gfg.length; ++j) {
				if(gfg[i].compareTo(gfg[j]) == 0) {
					System.out.print(gfg[j]);
				}
			}
		}
	}

}
