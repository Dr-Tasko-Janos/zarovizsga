package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> allDogs = new ArrayList<>();

    public void addDog(Dog dog) {
        allDogs.add(dog);
    }

    public void feedAll() {
        for (Dog item : allDogs) {
            item.feed();
        }
    }

    public Dog findByName(String name) {
        Dog foundDog = null;
        for (Dog item : allDogs) {
            if (item.getName().equals(name)) {
                foundDog = item;
            } else {
                throw new IllegalArgumentException("The dog with the given name(" + name + ") not found");
            }
        }
        return foundDog;
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();

        for (Dog item : allDogs) {
            if (item.getHappiness() > minHappiness) {
                happyDogs.add(item.getName());
            }
        }
        return happyDogs;
    }
}
