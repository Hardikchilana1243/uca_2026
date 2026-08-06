#include <stdio.h>

int bang(int x) {
    return ((x | (~x + 1)) >> 31) + 1;
}

int main() {
    int x;

    printf("Enter an integer: ");
    scanf("%d", &x);

    printf("bang(%d) = %d\n", x, bang(x));

    return 0;
}