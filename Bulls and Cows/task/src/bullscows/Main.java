package bullscows;

import java.util.*;

public class Main {

    static char[] code;
    static boolean exit = false;

    public static void main(String[] args) {
        InputStr inputStr = new InputStr();

        code = generateSecret(inputStr.readCount());

        System.out.println("Okay, let's start a game!");
        guessCode(inputStr);
    }

    private static char[] generateSecret(int count) {
        char[] code = new char[count];
        char[] pseudoRandom = String.valueOf(System.nanoTime()).toCharArray();
        int j = 0;
        HashSet tmpHash = new HashSet<>();
        for (int i = pseudoRandom.length - 1; i >= 0; i--) {
            if (j == 0 && pseudoRandom[i] != '0') {
                code[j] = pseudoRandom[i];
                j++;
                tmpHash.add(pseudoRandom[i]);
            }
            if (j != 0 && tmpHash.add(pseudoRandom[i])) {
                code[j] = pseudoRandom[i];
                j++;
            }
            if (j > count - 1) break;
        }
        return code;
    }

    private static void guessCode(InputStr inputStr) {
        int counter = 0;
        do {
            counter++;
            System.out.println("Turn " + counter + ". Answer:");
            String str = checkBulls(inputStr.nextAnswer(code.length));
            if (str == null) break;

            System.out.println("Grade: " + str + ".\n");

        } while (!exit);
        if (exit) System.out.println("Congratulations! You guessed the secret code.");
    }

    private static String checkBulls(char[] answer) {
        int bulls = 0;
        int cows = 0;
        HashSet<Character> tmp = new HashSet<>();
        for (char a : code) tmp.add(a);

        assert (answer != null);
        if (code.length != answer.length) {
            System.out.println("Enter correct length.\n code.length = " + code.length +
                    "\t\tanswer.length = " + answer.length + "\n" +
                    "code = " + String.valueOf(code) + "\t\t answer = \'" +
                    String.valueOf(answer) + "\'");
            return "None";
        }

        for (int i = 0; i < code.length; i++) {
            if (code[i] == answer[i]) bulls++;
            else if (!tmp.add(answer[i])) cows++;
        }

        String strBulls = null, strCows = null;
        if (bulls != 0) {
            strBulls = bulls + " bull" + (bulls == 1 ? "" : "s");
        }
        if (cows != 0) {
            strCows = cows + " cow" + (cows == 1 ? "" : "s");
        }

        if (bulls == code.length) exit = true;
        String str;
        if (bulls + cows == 0) str = "None";
        else if (bulls * cows != 0) str = strBulls + " and " + strCows;
        else if (bulls != 0) str = strBulls;
        else str = strCows;
        return str;
    }
}
