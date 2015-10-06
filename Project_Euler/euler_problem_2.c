#include <stdio.h>
#include <assert.h>

/*
 * Solution Theory:
 * If we let fib(0) = 0, fib(1) = 1, then we see that starting with n = 0, an
 * even number will occur every 3n terms:
 *      n:     0    1    2    3    4    5    6    7
 * fib(n):     0    1    1    2    3    5    8   13
 * We can then modify our recursive formula for fib(n) to improve speed, using
 * dynamic programming.
 * Let's start with x = 0, y = 1. The next number will be x + y, and then the
 * next will be x + 2y. Let x + 2y be the new x. Since x is even, this will
 * ensure that we will be generating even primes! Instead of incrementing our
 * counter by 1, we increment by 3!
 *
 * Sequence: x y (x + y) (x + 2y) (2x + 3y)
 *                         NEW_X    NEW_Y
 */

int main() {
    int x, y, sum;
    x = 0;
    y = 1;
    sum = 0;
    while (x < 4000000) {
        assert(x % 2 == 0);
        sum += x;
        int tmp = y;
        y = (2 * x) + (3 * y);
        x = x + (2 * tmp);
    }
    printf("Sum of the even-valued Fibonacci nums below 4,000,000: %d\n" , sum);
    return 0;
}
