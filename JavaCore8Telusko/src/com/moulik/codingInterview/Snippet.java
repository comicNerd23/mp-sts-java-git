package com.moulik.codingInterview;

public class Snippet {
	
	public static int firstOccurrence(String s, String x) {
        char[] xArr = x.toCharArray();
		char[] sArr = s.toCharArray();
		char[] aStr = {};
		int a = -1;
		if(!x.contains("*")) {
			if(s.contains(x)) {
				return s.indexOf(x);
			} else {
				return -1;
			}
		}
		int indexOfStar = x.indexOf("*");
		if(indexOfStar == 0) {
			String xSub = x.substring(1);
			if(s.substring(1).contains(xSub)) {
				return s.indexOf(xSub)-1;
			} else {
				return -1;
			}
		} else {
			for (int i = 0; i < sArr.length; i++) {
				if (sArr[i] == xArr[0]) {
					aStr = s.subSequence(i, i + x.length()).toString().toCharArray();
					System.out.println("aStr:" + String.valueOf(aStr));
					boolean notFound = false;
					if(aStr.length == x.length()) {
						for (int m = 0; m < aStr.length; m++) {
							if (xArr[m] == '*') {
								continue;
							} else if (xArr[m] == aStr[m]) {
								continue;
							} else if(xArr[m] != aStr[m]) {
								notFound = true;
								break;
							}
						}
						if(!notFound) {
							a = i;
							break;
						}
					}
				}
			}
		}
		return a;

    }
	
	public static void main(String[] args) {
		

		
		String str = "this is java code";
        String words[]=str.split("\\s");
        String capitalizeStr="";
 
        for(String word:words){
            // Capitalize first letter
            String firstLetter=word.substring(0,1);
            // Get remaining letter
            String remainingLetters=word.substring(1);
            capitalizeStr+=firstLetter.toUpperCase()+remainingLetters+" ";
        }
        //System.out.println(capitalizeStr);
        
        String str1 = "juliasamanthasamanthajulia";
        String x = "man*ha";
        //String x = "julia";
        System.out.println(firstOccurrence(str1, x));
        
	}
	

	    /*
	     * Complete the 'firstOccurrence' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. STRING s
	     *  2. STRING x
	     */

	    

	
	
}

