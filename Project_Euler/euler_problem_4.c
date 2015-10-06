#include <stdio.h>
#include <assert.h>

typedef int bool;

bool is_palindrome(int i) {
    int tmp, rev;
    tmp = i;
    rev = 0;
    while (tmp > 0) {
        rev = rev * 10 + tmp % 10;
        tmp = tmp / 10;
    }
    return rev == i;
}

int main() {
    int factor1, factor2, ans;
    ans = 0;
    for (factor1 = 999; factor1 > 100; factor1--) {
        if (factor1 % 10 == 0) {
            continue; // If 10 is a factor, it's impossible to be palindromic
        }
        for (factor2 = factor1; factor2 > 100; factor2--) {
            if (factor2 % 10 == 0) {
                continue; // Same reason as above.
            }
            if (is_palindrome(factor1 * factor2)) {
                if (factor1 * factor2 > ans) {ans = factor1 * factor2;}
            }
        }
    }
    printf("Largest palindromic product of 2 3-digit numbers: %d\n", ans);
    return 0;
}
