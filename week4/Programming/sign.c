#include <stdio.h>

int sign(int x) {
    return (x >> 31) | (!!x);
}

int main() {
    int x;

    printf("Enter an integer: ");
    scanf("%d", &x);

    printf("Sign = %d\n", sign(x));

    return 0;
}