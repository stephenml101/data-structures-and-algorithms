# Quick Sort Explanation

- Today we will get code to analyze and go through it step-by-step. Please see the code below:

``` java
class Main {
  public static void main(String[] args) {
    int[] unsortedArr = {5, 2, 1, 4, 0, 3};
    System.out.println("unsorted array: " + java.util.Arrays.toString(unsortedArr));

    quickSort(unsortedArr, 0, unsortedArr.length - 1);

    System.out.println("sorted array: " + java.util.Arrays.toString(unsortedArr));
  }

  static void quickSort(int[] arr, int low, int high) {
    if(low < high) {
      int pivotLocation = partition(arr, low, high);
      quickSort(arr, low, pivotLocation - 1);
      quickSort(arr, pivotLocation + 1, high);
    }
  }

  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int leftwall = low;

    for(int i = low; i < high; i++) {
      if(arr[i] <= pivot) {
        int temp = arr[i];
        arr[i] = arr[leftwall];
        arr[leftwall] = temp;
        leftwall+=1;
      }
    }

    int temp = arr[leftwall];
    arr[leftwall] = arr[high];
    arr[high] = temp;

    return leftwall;
  }
}
```

![Picture](/java/datastructures/lib/img/quickSort.jpeg)


