#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

typedef struct big_num b_num;

// Note that the digits in big_num structs are REVERSED!!!!
struct big_num {
    char value[1000]; // Array representation of 1000 "digit" number
    char tmp_buf[1000];
    int digit_counter;
};

void reset_big_num(b_num* bn) {
    for (int i = 0; i < 1000; i++) {
        bn->value[i] = 0;
    }
}

void carry(b_num* bn, int index) {
    if (index > bn->digit_counter) return;
    if (bn->value[index] >= 10) {
        bn->value[index + 1]++;
        bn->value[index] -= 10;
        if (bn->digit_counter == index) {bn->digit_counter++;}
        carry(bn, index + 1);
    }
}

void double_big_num(b_num* bn) {
    int i, tmp_count;
    tmp_count = bn->digit_counter;
    for (i = 0; i <= tmp_count; i++) {
        bn->tmp_buf[i] = bn->value[i];
    }
    for (i = 0; i <= tmp_count; i++) {
        bn->value[i] += bn->tmp_buf[i];
        carry(bn, i);
    }
}

void print_big_num(b_num* bn) {
    int i;
    for (i = bn->digit_counter; i >= 0; i--) {
        printf("%hhd", bn->value[i]);
    }
    printf("\n");
}

int main() {
    b_num* n = malloc(sizeof(b_num));
    reset_big_num(n);
    n->value[0] = 1;
    n->digit_counter = 0;
    int i, sum;
    for (i = 0; i < 1000; i++) {
        double_big_num(n);
    }
    sum = 0;
    for (i = 0; i <= n->digit_counter; i++) {
        sum += n->value[i];
    }
    printf("Sum of digits of 2^1000: %d\n", sum);
    free(n);
    return 0;
}
