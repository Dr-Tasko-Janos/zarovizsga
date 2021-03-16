package hu.nive.ujratervezes.zarovizsga.workhours;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        int counter = 0;
        String givenText = s;

        for (int i = 0; i < givenText.length(); i++) {
            {
                if (Character.isDigit(s.charAt(i)))
                    counter++;
            }
        }
        return counter;
    }

   /* public static void main(String[] args) {
        int numberOfNumericCharacters = new DigitsCounter().getCountOfDigits("This 1 string contains2 three 3 numeric characters.");
        System.out.println(numberOfNumericCharacters);
    }*/
}
