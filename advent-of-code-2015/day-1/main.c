#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    char buffer[10240]; // 10 KB
    int fd = open("in.in", O_RDONLY);
    int bytes_read = read(fd, buffer, sizeof(buffer));
    printf("Read %d bytes\n", bytes_read);
    buffer[bytes_read] = '\0'; // Terminate string
    close(fd);

    int sum = 0;
    int i = 0;
    int reached_basement = -1;
    while (buffer[i]) {
        if (sum == -1 && reached_basement == -1) {
            reached_basement = i;
        }
        if (buffer[i] == '(') sum++;
        if (buffer[i] == ')') sum--;
        i++;
    }

    printf("Went through %d floors\n", i);
    printf("[Part 1:] Go to floor: %d\n", sum);
    printf("[Part 2:] First arrived in basement at position %d\n", reached_basement);
    return 0;
}

