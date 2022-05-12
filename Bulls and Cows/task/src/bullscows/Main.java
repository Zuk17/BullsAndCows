package bullscows;

import static bullscows.Checker.exit;

public class Main {

    public static void main(String[] args) {
        InputStr inputStr = new InputStr();

        int lengthCode = inputStr.readCount();
        int possibleElements = inputStr.readPossible();
        char[] secretCode = SecretCode.generate(lengthCode, possibleElements);

        assert secretCode != null;
        System.out.println("secret code = " + String.valueOf(secretCode));
        System.out.println("Okay, let's start a game!");

        int counter = 0;
        do {
            counter++;
            System.out.println("Turn " + counter + ". Answer:");
            String str = Checker.checkBulls(inputStr.nextAnswer(lengthCode), secretCode);
            if (str == null) break;

            System.out.println("Grade: " + str + ".\n");

        } while (!exit);
        if (exit) System.out.println("Congratulations! You guessed the secret code.");
    }
}
