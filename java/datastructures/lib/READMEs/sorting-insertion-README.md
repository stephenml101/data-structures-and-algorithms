# Code Challenge 26

- Review the pseudocode below, then trace the algorithm by stepping through the process with the provided sample array. Document your explanation by creating a blog article that shows the step-by-step output after each iteration through some sort of visual.

Pseudocode
``` java
Insert(int[] sorted, int value)
  initialize i to 0
  WHILE value > sorted[i]
    set i to i + 1
  WHILE i < sorted.length
    set temp to sorted[i]
    set sorted[i] to value
    set value to temp
    set i to i + 1
  append value to sorted

InsertionSort(int[] input)
  LET sorted = New Empty Array
  sorted[0] = input[0]
  FOR i from 1 up to input.length
    Insert(sorted, input[i])
  return sorted
  ```

Given array: [8, 4, 23, 42, 16, 15]

1. InsertionSort(int[] input)

- Input: [8, 4, 23, 42, 16, 15]
- sorted = []
2. sorted[0] = input[0]

- Input: [8, 4, 23, 42, 16, 15]
- sorted = [8]
3. Loop iteration: i = 1

- Call Insert(sorted, input[i])
  - Input: sorted = [8], value = 4
- Inside Insert function:
  - i = 0
  - Since value (4) is not greater than sorted[i] (8), the loop condition fails.
  - i is still 0, so the next loop condition also fails.
  - Append value (4) to sorted.
  - sorted = [8, 4]
4. Loop iteration: i = 2

- Call Insert(sorted, input[i])
  - Input: sorted = [8, 4], value = 23
- Inside Insert function:
  - i = 0
  - Since value (23) is greater than sorted[i] (8), the loop condition passes.
  - Increment i to 1.
  - Since value (23) is greater than sorted[i] (4), the loop condition passes.
  - Increment i to 2.
  - The loop condition fails since i is now equal to 2.
  - Set temp = sorted[i] = 23
  - Set sorted[i] = value = 23
  - Set value = temp = 23
  - Increment i to 3.
  - Append value (23) to sorted.
  - sorted = [8, 4, 23]
5. Loop iteration: i = 3

- Call Insert(sorted, input[i])
   -Input: sorted = [8, 4, 23], value = 42
- Inside Insert function:
  - i = 0
  - Since value (42) is greater than sorted[i] (8), the loop condition passes.
  - Increment i to 1.
  - Since value (42) is greater than sorted[i] (4), the loop condition passes.
  - Increment i to 2.
  - Since value (42) is greater than sorted[i] (23), the loop condition passes.
  - Increment i to 3.
  - The loop condition fails since i is now equal to 3.
  - Set temp = sorted[i] = 42
  - Set sorted[i] = value = 42
  - Set value = temp = 42
  - Increment i to 4.
  - Append value (42) to sorted.
  - sorted = [8, 4, 23, 42]
6. Loop iteration: i = 4

- Call Insert(sorted, input[i])
  - Input: sorted = [8, 4, 23, 42], value = 16
- Inside Insert function:
  - i = 0
  - Since value (16) is greater than sorted[i] (8), the loop condition passes.
  - Increment i to 1.
  - Since value (16) is not greater than sorted[i] (4), the loop condition fails.
  - i is still 1, so the next loop condition also fails.
  - Append value (16) to sorted.
  - sorted = [8, 4, 23, 42, 16]
7. Loop iteration: i = 5

- Call Insert(sorted, input[i])
  - Input: sorted = [8, 4, 23, 42, 16], value = 15
- Inside Insert function:
  - i = 0
  - Since value (15) is greater than sorted[i] (8), the loop condition passes.
  - Increment i to 1.
  - Since value (15) is not greater than sorted[i] (4), the loop condition fails.
  - i is still 1, so the next loop condition also fails.
  - Append value (15) to sorted.
  - sorted = [8, 4, 23, 42, 16, 15]
  - Return sorted array: [8, 4, 23, 42, 16, 15]
```java
The final sorted array is [8, 4, 23, 42, 16, 15]
```
