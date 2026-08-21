#include <stdio.h>

int fitsBits(int x, int n) {
    int shift = 32 + (~n + 1);   
    return !(((x << shift) >> shift) ^ x);
}

int main() {
    int x, n;

    printf("Enter x and n: ");
    scanf("%d %d", &x, &n);

    printf("%d\n", fitsBits(x, n));

    return 0;
}