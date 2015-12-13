#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>

#define _input_file     "in.in"
#define _output_file    "out.out"

char *data;
char *outstring;

int read_input() {
    int fd = open(_input_file, O_RDONLY);
    close(fd);
}

int writeout() {
    int fd = open(_output_file, O_RDONLY | O_WRONLY | O_CREAT | O_TRUNC, 0644);
    write(fd, outstring, sizeof(*outstring));
    close(fd);
    return errno;
}

int main() {
    read_input();
    writeout();
    return 0;
}

