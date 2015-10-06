#include <stdio.h>
#include <assert.h>

int expon(int b, int e) {
    if (e == 0) {
        return 1;
    } else {
        return b * expon(b , e - 1);
    }
}

int reduced_factorial(int n) {
    int primes[n + 1];
    int i, j, tmp, answer, div_count;
    answer = 1;
    div_count = 0;
    for (i = 0; i <= n; i++) {
        primes[i] = 0;
    }
    for (i = 2; i <= n; i++) {
        tmp = i;
        for (j = 2; j < i - 1; j++) {
            if (primes[j] == 0) {
                continue;
            }
            div_count = 0;
            while (tmp % j == 0) {
                tmp = tmp / j;
                div_count += 1;
                if (div_count > primes[j]) primes[j] += 1;
            }
        }
        if (tmp == i) {
            primes[i] += 1;
        }
    }
    for (i = 2; i <= n; i++) {
        answer *= primes[i] == 0 ? 1 : expon(i, primes[i]);
    }
    return answer;
}

int main() {
    printf("%d\n", reduced_factorial(20));
    return 0;
}
