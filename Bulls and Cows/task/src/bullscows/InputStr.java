package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputStr {
    private final Scanner scanner;

    public InputStr() {
        scanner = new Scanner(System.in);
    }

    public int readCount() {
        int count;
        do {
            System.out.println("Input the length of the secret code:");
            try {
                count = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException e) {
                continue;
            }

            if (count > 36) {
                System.out.println("Error: can't generate a secret number with " +
                        "a length of " + count + " because there aren't enough unique digits.");
                continue;
            }
            break;
        } while (true);
        return count;
    }

    public int readPossible() {
        int count = -1;
        do {
            System.out.println("Input the number of possible symbols in the code:");
            try {
                count = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (count > 36) {
                System.out.println("Error: can't generate a secret number with " +
                        count + " numbers variable. because we can only 0-9, a-z.");
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
                if (!answer.matches("[0-9, a-z]*") || answer.length() != codeLength) {
                    System.out.println("Wrong input answer.");
                    System.out.println("Enter correct length.\n code.length = " + codeLength +
                            "\t\tanswer.length = " + answer.length() + "\n" +
                            "answer = '" + answer + "'");
                    answer = "";
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Exiting by end of scanner");
            return null;
        }
        assert answer != null;
        return answer.toCharArray();
    }
}
