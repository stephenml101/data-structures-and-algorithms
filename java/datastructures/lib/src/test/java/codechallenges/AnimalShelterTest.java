package src.test.java.codechallenges;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.codechallenges.AnimalShelter;
import src.main.java.codechallenges.AnimalShelter.Animal;
import src.main.java.codechallenges.AnimalShelter.Species;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AnimalShelterTest {
  private AnimalShelter sut;

  @BeforeEach
  public void setUp() {
    sut = new AnimalShelter();
    Animal ralph = sut.new Animal(Species.dog, "Ralph");
    Animal jenna = sut.new Animal(Species.cat, "Jenna");
    Animal sandy = sut.new Animal(Species.cat, "Sandy");
    Animal jello = sut.new Animal(Species.cat, "Jello");

    sut.enqueue(jello);
    sut.enqueue(sandy);
    sut.enqueue(jenna);
    sut.enqueue(ralph);
  }

  @Test
  public void dequeueWithPreference() {
    assertEquals("Ralph", sut.dequeue(Species.dog));
    assertEquals("Jello", sut.dequeue(Species.cat));
  }

  @Test
  public void dequeueWithoutPreference() {
    assertEquals("Jello", sut.dequeue(Species.none));
  }

  @Test
  public void dequeueWithPreferenceWithoutAvailablility() {
    AnimalShelter sut = new AnimalShelter();
    Animal sandy = sut.new Animal(Species.cat, "Sandy");
    Animal jello = sut.new Animal(Species.cat, "Jello");
    sut.enqueue(jello);
    sut.enqueue(sandy);

    assertNull(sut.dequeue(Species.dog));
  }

  @Test
  public void dequeueOnEmptyQueueReturnsNull() {
    AnimalShelter emptySut = new AnimalShelter();
    assertNull(emptySut.dequeue(Species.dog));
  }
}
