# Problem

Problem 3: Cow Jog [Mark Gordon, 2014]

The cows are out exercising their hooves again!  There are N cows
jogging on an infinitely-long single-lane track (1 <= N <= 100,000).
Each cow starts at a distinct position on the track, and some cows jog
at different speeds.

With only one lane in the track, cows cannot pass each other.  When a
faster cow catches up to another cow, she has to slow down to avoid
running into the other cow, becoming part of the same running group.

Eventually, no more cows will run into each other.  Farmer John
wonders how many groups will be left when this happens.  Please help
him compute this number.

## Input Format

INPUT: (file cowjog.in)

The first line of input contains the integer N.

The following N lines each contain the initial position and speed of a
single cow.  Position is a nonnegative integer and speed is a positive
integer; both numbers are at most 1 billion.  All cows start at 
distinct positions, and these will be given in increasing order in
the input.

SAMPLE INPUT:

5
0 1
1 2
2 3
3 2
6 1

## Output Format

OUTPUT: (file cowjog.out)

A single integer indicating how many groups remain.

SAMPLE OUTPUT:

2

## Solution (Java)

# class cow

A readable class to make the rest of the solution easier, and the code more readable / understandable

# main()

Gets data from cowjog.in and stores it in an array of cows by passing the data into the cow constructor

# remainingGroups(cow[] race)

The logic behind this solution is flawed because I missed a base case, but my logic was to start from the back and see
if the one before it would catch up via higher speeds. If it did catch up, I would conglomerate the 2 cows and start 
the process over from this new "multi cow."
