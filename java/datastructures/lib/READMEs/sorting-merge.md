# Sorting Arrays with Merge Sort

Merge Sort is a popular sorting algorithm known for its efficiency. It follows the divide-and-conquer approach, where a large array is divided into smaller subarrays until each subarray consists of only one element. Then, the subarrays are merged back together, sorting them in the process. In this article, we will explore the step-by-step process of Merge Sort using a sample array: [8, 4, 23, 42, 16, 15]. Let's dive in!

## Step 1: Initial Array

Let's start with the initial array: [8, 4, 23, 42, 16, 15].

## Step 2: Splitting the Array

The first step of Merge Sort is to split the array into smaller subarrays. We repeatedly divide the array until each subarray contains only one element. Here's how the splitting process looks for our sample array:

``` java
[8, 4, 23, 42, 16, 15]
```

``` java
[8, 4, 23]   [42, 16, 15]
```

``` java
[8] [4, 23]   [42] [16, 15]
```

``` java
[8] [4] [23]   [42] [16] [15]
```
