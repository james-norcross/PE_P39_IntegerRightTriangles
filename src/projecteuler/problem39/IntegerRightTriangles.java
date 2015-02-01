package projecteuler.problem39;

import java.util.Arrays;

public class IntegerRightTriangles {

	/**
	 * Author: James Norcross
	 * Date: 1/30/15
	 * Purpose: Project Euler Problem 39
	 * Description: Finds the perimeter that occurs most often for right triangles with integer side lengths with perimeter less
	 * than 1000
	 */
	
	private static final int MAX_PERIMETER = 1000;
	private static int[] pFreq = new int[MAX_PERIMETER + 1];
	
	public static void main(String[] args) {
		
		Arrays.fill(pFreq, 0);
		
		for (int a = 1; a < MAX_PERIMETER/2; a++ )
		{
			for (int b = a; b < (MAX_PERIMETER - a) ; b++)
			{
				int c1 = (int)Math.floor(Math.sqrt((double)(a*a + b*b)));
				int c2 = (int)Math.ceil(Math.sqrt((double)(a*a + b*b)));
				
				if(((a*a + b*b) == (c1*c1)) && ((a + b + c1) < MAX_PERIMETER))
					pFreq[a + b + c1]++;
				if ((c2 != c1) && ((a*a + b*b) == (c2*c2)) && ((a + b + c1) < MAX_PERIMETER))
					pFreq[a + b + c2]++;
			}
		}
		
		int maxpFreq = 0;
		int maxp = 0;
		
		for (int i = 1; i <= MAX_PERIMETER; i++)
		{
			if(pFreq[i] > maxpFreq)
			{
				maxpFreq = pFreq[i];
				maxp = i;
			}
		}
		
		System.out.println("The most frequent p is " + maxp + " which occurs " + maxpFreq + " times");

	}

}
