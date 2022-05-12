package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStr {
    private final Scanner scanner;

    public InputStr() {
        scanner = new Scanner(System.in);
    }

    private int readInt() {
        int count = -1;
            String str = scanner.nextLine();
            if (!str.matches("[0-9]*"))
                System.out.println("Error: \"" + str + "\" isn't a valid number.");
            else
                count = Integer.parseInt(str);
        return count;
    }

    public int readCount() {
        System.out.println("Input the length of the secret code:");
        int count = readInt();
        if (count > 36)
            System.out.println("Error: can't generate a secret number with " +
                    "a length of " + count + " because there aren't enough unique digits.");
        return count;
    }

    public int readPossible() {
        System.out.println("Input the number of possible symbols in the code:");
        int count = readInt();
        if (count > 36)
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        return count;
    }

    public char[] nextAnswer(int codeLength) {
        String answer = null;
        if (scanner.hasNext()) {
            try {
                answer = scanner.nextLine();
                if (!answer.matches("[0-9, a-z]*") || answer.length() != codeLength) {
                    System.out.println("Wrong input answer.");
                    System.out.println("Enter correct length.\n code.length = " + codeLength +
                            "\t\tanswer.length = " + answer.length() + "\n" +
                            "answer = '" + answer + "'");
                    answer = "";
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Exiting by end of scanner");
            return null;
        }
        assert answer != null;
        return answer.toCharArray();
    }
}
