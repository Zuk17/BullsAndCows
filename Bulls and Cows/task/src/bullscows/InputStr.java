package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStr {
    private Scanner scanner;

    public InputStr() {
        scanner = new Scanner(System.in);
    }

    public int readCount() {
        int count = 0;
        do {
            System.out.println("Please, enter the secret code's length:");
            try {
                count = Integer.valueOf(scanner.nextLine());
            } catch (InputMismatchException e) {
                continue;
            }

            if (count > 10) {
                System.out.println("Error: can't generate a secret number with " +
                        "a length of " + count + " because there aren't enough unique digits.");
                continue;
            }
            break;
        } while (true);
        return count;
    }

    public char[] nextAnswer(int codeLength) {
        String answer = null;
        if (scanner.hasNext()) {
            try {
                answer = scanner.nextLine();
                if (!answer.matches("[0-9]*") || answer.length() != codeLength) {
                    System.out.println("Wrong input answer.");
                    System.out.println("Enter correct length.\n code.length = " + codeLength +
                            "\t\tanswer.length = " + answer.length() + "\n" +
                            "answer = \'" + answer + "\'");
                    answer = "";
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Exiting by end of scanner");
            return null;
        }
        return answer.toCharArray();
    }
}
