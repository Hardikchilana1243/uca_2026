#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int (*Compare)(const void *, const void *);

/* Swap two elements of any data type */
void swap(void *a, void *b, size_t size)
{
    void *temp = malloc(size);

    memcpy(temp, a, size);
    memcpy(a, b, size);
    memcpy(b, temp, size);

    free(temp);
}

/* Heapify */
void heapify(void *arr, int n, int i, size_t size, Compare cmp)
{
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    char *base = (char *)arr;

    if (left < n &&
        cmp(base + left * size, base + largest * size) > 0)
    {
        largest = left;
    }

    if (right < n &&
        cmp(base + right * size, base + largest * size) > 0)
    {
        largest = right;
    }

    if (largest != i)
    {
        swap(base + i * size,
             base + largest * size,
             size);

        heapify(arr, n, largest, size, cmp);
    }
}

/* Generic Heap Sort */
void heapSort(void *arr, int n, size_t size, Compare cmp)
{
    /* Build max heap */
    for (int i = n / 2 - 1; i >= 0; i--)
    {
        heapify(arr, n, i, size, cmp);
    }

    /* Extract elements one by one */
    for (int i = n - 1; i > 0; i--)
    {
        swap((char *)arr,
             (char *)arr + i * size,
             size);

        heapify(arr, i, 0, size, cmp);
    }
}

/* Comparator for integers */
int compareInt(const void *a, const void *b)
{
    int x = *(const int *)a;
    int y = *(const int *)b;

    return x - y;
}

/* Comparator for doubles */
int compareDouble(const void *a, const void *b)
{
    double x = *(const double *)a;
    double y = *(const double *)b;

    if (x > y)
        return 1;
    if (x < y)
        return -1;

    return 0;
}

/* Comparator for characters */
int compareChar(const void *a, const void *b)
{
    char x = *(const char *)a;
    char y = *(const char *)b;

    return x - y;
}

int main()
{
    int arr[] = {10, 3, 7, 1, 9, 5, 2};
    int n = sizeof(arr) / sizeof(arr[0]);

    heapSort(arr, n, sizeof(int), compareInt);

    printf("Sorted integers: ");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    printf("\n");

    double nums[] = {4.5, 1.2, 9.8, 3.4, 2.1};
    int m = sizeof(nums) / sizeof(nums[0]);

    heapSort(nums, m, sizeof(double), compareDouble);

    printf("Sorted doubles: ");
    for (int i = 0; i < m; i++)
    {
        printf("%.1f ", nums[i]);
    }

    printf("\n");

    char chars[] = {'z', 'a', 'm', 'c', 'b'};
    int k = sizeof(chars) / sizeof(chars[0]);

    heapSort(chars, k, sizeof(char), compareChar);

    printf("Sorted characters: ");
    for (int i = 0; i < k; i++)
    {
        printf("%c ", chars[i]);
    }

    return 0;
}