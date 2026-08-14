// I would use two heaps to maintain the median efficiently:

// * A Max Heap stores the smaller half of the numbers.
// * A Min Heap stores the larger half of the numbers.

// The heaps are kept balanced so that their sizes differ by at most one.

// For `insert(int num)`, the number is inserted into the appropriate heap and the heaps are rebalanced if necessary. This takes **O(log n)** time.

// For `getMedian()`, if both heaps have the same size, the median is the average of their top elements. Otherwise, the top element of the larger heap is the median. This takes **O(1)** time.

// The overall space complexity is **O(n)** because all received numbers are stored in the two heaps.

// **Time Complexity:**

// * `insert()` → O(log n)
// * `getMedian()` → O(1)
// * Space → O(n)

