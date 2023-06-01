# Code Challenge 12

## Summary
- Create a class called AnimalShelter which holds only dogs and cats.
  - The shelter operates using a first-in, first-out approach.
Implement the following methods:
- enqueue
  - Arguments: animal
  - animal can be either a dog or a cat object.
  - It must have a species property that is either "cat" or "dog"
  - It must have a name property that is a string.
  - dequeue
    - Arguments: pref
    - pref can be either "dog" or "cat"
    - Return: either a dog or a cat, based on preference.
    - If pref is not "dog" or "cat" then return null.

## Whiteboard
![cc12.png](..%2F..%2F..%2F..%2Fimg%2Fcc12.png)

# Efficiency
Using a second queue in dequeue to get the return value in an easier manner and utilizing concepts taught in previous classes.

enqueue:

- Time: O(1)
- Space: O(1)

dequeue:

- Time: O(1)
- Space: O(n)

[Animal Shelter Class]([AnimalShelter.java](AnimalShelter.java))
[Animal Shelter Test]([AnimalShelterTest.java](..%2F..%2F..%2Ftest%2Fjava%2Fcodechallenges%2FAnimalShelterTest.java))
