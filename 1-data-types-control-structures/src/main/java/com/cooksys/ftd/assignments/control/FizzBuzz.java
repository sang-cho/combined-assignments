package com.cooksys.ftd.assignments.control;

import java.util.Arrays;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * FizzBuzz is an old programming exercise.
 * The goal is to iterate over a range of numbers and print a message about each number's divisibility.
 * <p>
 * The message is generated the following way:
 * *) if the number is divisible by three, the message is `Fizz`
 * *) if the number is divisible by five, the message is `Buzz`
 * *) if the number is divisible by both three and five, the message is `FizzBuzz`
 * *) otherwise, no message is produced
 * <p>
 * The exact message format for this assignment is specified in the `message(n)` method.
 */
public class FizzBuzz {

    /**
     * Checks whether a given int `a` is evenly divisible by a given int `b` or not.
     * For example, `divides(4, 2)` returns `true` and `divides(4, 3)` returns `false`.
     *
     * @param a the number to be divided
     * @param b the number to divide by
     * @return `true` if a is evenly divisible by b, `false` otherwise
     * @throws IllegalArgumentException if b is zero
     */
    public static boolean divides(int a, int b) throws IllegalArgumentException {
		if (b==0){
			throw new IllegalArgumentException("Cannot divide by 0.");
		}

		return a%b==0;
    }

    /**
     * Generates a divisibility message for a given number. Returns null if the given number is not divisible by 3 or 5.
     * Message formatting examples:
     * 1 -> null // not divisible by 3 or 5
     * 3 -> "3: Fizz" // divisible by only 3
     * 5 -> "5: Buzz" // divisible by only 5
     * 15 -> "15: FizzBuzz" // divisible by both three and five
     *
     * @param n the number to generate a message for
     * @return a message according to the format above, or null if n is not divisible by either 3 or 5
     */
    public static String message(int n) {
    	String result=null;
    	if(divides(n,3)&&divides(n,5)){
    		result=n+ ": FizzBuzz"; 
    	}
    	else if(divides(n,3)){
    		result=n+ ": Fizz";
    	}
    	else if(divides(n,5)){
    		result=n+ ": Buzz";
    	}
    	return result;
        //throw new NotImplementedException();
    }

    /**
     * Generates an array of messages to print for a given range of numbers.
     * If there is no message for an individual number (i.e., `message(n)` returns null),
     * it should be excluded from the resulting array.
     *
     * @param start the number to start with (inclusive)
     * @param end the number to end with (exclusive)
     * @return an array of divisibility messages
     * @throws IllegalArgumentException if the given end is less than the given start
     */
    public static String[] messages(int start, int end) throws IllegalArgumentException {
		if(end<start) {
			throw new IllegalArgumentException();
		}

		int arraysize=end-start;
		int nullcount=0;

		String[] fizzbuzzmes=new String[arraysize];
		for (int i = 0; i < arraysize; i++) {
			if (message(start+i)==null){
				nullcount++;
			}
			fizzbuzzmes[i] = message(start + i);
		}
		int arraysize2=arraysize-nullcount;

		String[] fizzbuzzmes2=new String[arraysize2];

		int j=0;
		for (int i=0;i<arraysize;i++){
			if (message(start+i) != null){
				fizzbuzzmes2[j]=message(i+start);
				j++;
			}
		}
		return fizzbuzzmes2;
    }

    /**
     * For this main method, iterate over the numbers 1 through 115 and print
     * the relevant messages to sysout
     */
    public static void main(String[] args) {
    	messages(1,116);
    	for (int i=0;i<116;i++){
    		if (message(i)!=null) {
    			System.out.println(message(i));
			}
		}
    	//System.out.println(message(3));
		//System.out.println(Arrays.toString(messages(3,3)));
		//System.out.println(Arrays.toString(messages(3,4)));
		//System.out.println(Arrays.toString(messages(3,5)));
		//System.out.println(Arrays.toString(messages(3,6)));
    	//System.out.println(Arrays.toString(messages(3,7)));
		//System.out.println(Arrays.toString(messages(12,16)));
        //System.out.println((messages(7,3)));

    }
}
