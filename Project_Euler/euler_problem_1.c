#include <stdio.h>
#include <assert.h>

typedef int bool;

bool is_mult_3_or_5(int i) {
    return (i % 3 == 0) || (i % 5 == 0);
}

int main() {
    /*
     * Declare counter variable and answer variable, initiate answer variable
     * to 0
     */
    int i;
    unsigned int answer = 0; // Enlarge range of answer to 2^32 - 1, since we
                             // don't want negative numbers.

    /*
     * Loop through integers between 1 and 999, add to answer if condition is
     * true.
     */
    for (i = 1; i < 1000; i++) {
        if (is_mult_3_or_5(i)) {
            answer += i;
        }
    }

    // Print out answer
    printf("Sum of all the multiples of 3 or 5 below 1000: %d\n", answer);

    // Return 0, for the sake of the exit code.
    return 0;
}
