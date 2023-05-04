package src.main.java.codechallenges;

import src.main.java.datastructures.queue.Queue;

public class AnimalShelter {

  public enum Species {
    dog,
    cat,
    none
  }

  public AnimalShelter() {
    queue = new Queue<Animal>();
  }

  private Queue<Animal> queue;

  public class Animal {
    private Species species;
    private String name;

    public Animal(Species species, String name) {
      this.species = species;
      this.name = name;
    }

    public Species getSpecies() {
      return species;
    }

    public void setSpecies(Species species) {
      this.species = species;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  // Methods
  public void enqueue(Animal animal) {
    queue.enqueue(animal);
  }

  // handles empty queue error throwing
  public String dequeue(Species pref) {
    // No species, dequeue the next animal
    if (pref == Species.none) {
      // This will return null if queue is empty
      return queue.dequeue().getName();
    }

    Queue<Animal> newQueue = new Queue<>();
    boolean animalDequeued = false;
    String name = "";

    // Traverse queue; transfer to newQueue until we reach right species
    while (!queue.isEmpty()) {
      Animal current = queue.peek();
      if (current.getSpecies() == pref && newQueue.isEmpty()) {
        name = queue.dequeue().getName();
        return name;
      } else if (current.getSpecies() == pref && !animalDequeued) {
        name = queue.dequeue().getName();
        animalDequeued = true;
      } else {
        newQueue.enqueue(queue.dequeue());
      }
    }
    queue = newQueue;

    if (animalDequeued) {
      return name;
    } else {
      return null;
    }
  }
}
