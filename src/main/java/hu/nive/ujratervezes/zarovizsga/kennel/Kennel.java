package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private static List<Dog> allDogs = new ArrayList<>();

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
        Dog foundDog = null;
        for (Dog item : allDogs) {
            if (item.getName().equals(name)) {
                foundDog = item;
            } else {
                throw new IllegalArgumentException("The dog with the given name(" + name + ") not found");
            }
            foundDog.play(hours);
        }
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

    public List<Dog> getDogs() {
        return allDogs;
    }

/*   //A tesztesetek rendre elbuktak nem értettem, hogy miért, ám manuálisan minden szépen lefutott
        public static void main(String[] args) {
        Kennel kennel = new Kennel();

        Beagle beagle = new Beagle("Bigli");
        kennel.addDog(beagle);
        Husky husky = new Husky("Morzsi");
        kennel.addDog(husky);
        Husky husky2 = new Husky("Zokni");
        kennel.addDog(husky2);

        System.out.println(kennel.getDogs().get(1).getName());
        kennel.feedAll();
        System.out.println(kennel.getDogs().get(0).getHappiness());
        System.out.println(kennel.getDogs().get(1).getHappiness());
    }*/
}
