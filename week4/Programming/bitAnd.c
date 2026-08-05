#include <stdio.h>

int bitAnd(int x, int y) {
    return ~(~x | ~y);
}

int main() {
    int x, y;

    printf("Enter two integers: ");
    scanf("%d %d", &x, &y);

    int result = bitAnd(x, y);

    printf("Bitwise AND of %d and %d = %d\n", x, y, result);

    return 0;
}