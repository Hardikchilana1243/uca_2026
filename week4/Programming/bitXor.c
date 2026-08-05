#include <stdio.h>

int bitXor(int x, int y) {
    return ~(~(x & ~y) & ~(~x & y));
}

int main() {
    int x, y;

    printf("Enter two integers: ");
    scanf("%d %d", &x, &y);

    printf("Bitwise XOR of %d and %d = %d\n", x, y, bitXor(x, y));

    return 0;
}