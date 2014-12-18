# Problem

Problem 4: Learning by Example [Brian Dean, 2014]

Farmer John has been reading all about the exciting field of machine
learning, where one can learn interesting and sometimes unexpected
patterns by analyzing large data (he has even started calling one of
the fields on his farm the "field of machine learning"!).  FJ decides
to use data about his existing cow herd to build an automatic
classifier that can guess whether a cow will have spots or not.

Unfortunately, FJ hasn't been very good at keeping track of data about
his cows.  For each of his N cows (1 <= N <= 50,000), all he knows is
the weight of the cow, and whether the cow has spots.  Each of his
cows has a distinct weight.  Given this data, he builds what is called
a "nearest neighbor classifier".  To guess whether a new cow C will
have spots or not, FJ first finds the cow C' in his herd with weight
closest to that of C.  If C' has spots, then FJ guesses that C will
also have spots; if C' has no spots, FJ guesses the same for C.  If
there is not one unique nearest neighbor C' but rather a tie between
two of FJ's cows, then FJ guesses that C will have spots if one or
both these nearest neighbors has spots.

FJ wants to test his new automatic spot predictor on a group of new
cows that are just arriving at his farm.  After weighing these cows,
he sees that the new shipment of cows contains a cow of every integer
weight between A and B (inclusive).  Please determine how many of
these cows will be classified as having spots, using FJ's new
classifier.  Note that the classifier only makes decisions using data
from FJ's N existing cows, not any of the new cows.  Also note that
since A and B can both be quite large, your program will not likely
run fast enough if it loops from A to B counting by ones.

## Input Format

INPUT: (file learning.in) 

The first line of the input contains three integers N, A, and B
(1 <= A <= B <= 1,000,000,000).

The next N lines each describe a single cow.  Each line contains
either S W, indicating a spotted cow of weight W, or NS W, indicating
a non-spotted cow of weight W.  Weights are all integers in the range
1 ... 1,000,000,000. 

SAMPLE INPUT:

3 1 10
S 10
NS 4
S 1

## Output Format

OUTPUT: (file learning.out)

A single integer giving the number of incoming cows that FJ's
algorithm will classify as having spots.  In the example shown
here, the incoming cows of weights 1, 2, 7, 8, 9, and 10 
will all be classified as having spots.

SAMPLE OUTPUT:

6

## Solution

I didn't solve this one due to time constraints, but this is as far as I got:

`
	import java.util.Scanner;
	import java.io.PrintWriter;
	import java.io.File;
	import java.util.Arrays;

	class cow {

		public boolean spots = false;;
		public int weight = 0;

		public cow(String s , int w) {
			spots = s.length() == 1;
			weight = w;
		}

	}

	public class learning {

		public static int spotted(cow[] hasSpots , int lowerWeightBound , int higherWeightBound) {
			//Get midpoints
			int numSpotted = 0;
			float[] midpts = new float[hasSpots.length + 1];
			midpts[0] = (float)lowerWeightBound;
			midpts[midpts.length - 1] = (float)higherWeightBound;
			for (int i = 1; i < midpts.length - 1; i++) {
				midpts[i] = ((float)(hasSpots[i - 1].weight) + (float)(hasSpots[i].weight)) / 2;
				if (hasSpots[i - 1].spots) {
					numSpotted += Math.round(midpts[i] - midpts[i - 1]);
				}
			}
			return numSpotted;
		}


		public static void main(String[] args){
			Scanner inputStream = null;
			PrintWriter outputStream = null;
			try {
				inputStream = new Scanner(new File("learning.in"));
				outputStream = new PrintWriter("learning.out" , "UTF-8");
			} catch(Exception e){
				System.exit(0);
			}
			int N = Integer.parseInt(inputStream.next());
			int lW = Integer.parseInt(inputStream.next());
			int hW = Integer.parseInt(inputStream.next());
			cow[] ranch = new cow[N];
			for (int i = 0; i < N; i++){
				ranch[i] = new cow(inputStream.next() , Integer.parseInt(inputStream.next()));
			}
			int spotted = spotted(ranch , lW , hW);
			outputStream.println("" + spotted);
			outputStream.close();
		}

	}

`
