#include <stdio.h>

int isPower2(int x) {
    return !(x & (x + ~0)) & !!x & !(x >> 31);
}

int main() {
    int x;

    printf("Enter an integer: ");
    scanf("%d", &x);

    printf("Result = %d\n", isPower2(x));

    return 0;
}