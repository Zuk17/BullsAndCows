package bullscows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretCode {

    public static char[] generate(int lengthCode, int possibleSymbols) {
        if (lengthCode < 1 || possibleSymbols < 2) {
            System.out.println("Маловато будет.");
            return null;
        }
        if (lengthCode > possibleSymbols) {
            System.out.println("Слишком мало разрешенных символов для создания секретного ключа.");
            return null;
        }

        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < possibleSymbols; i++) {
            if (i < 10) alphabet.add((char) ('0' + i));
            else alphabet.add((char) ('a' + i - 10));
        }

        String strStatus = "The secret is prepared: " + "*".repeat(lengthCode) + " (0-";
        if (lengthCode < 10) strStatus += alphabet.get(alphabet.size() - 1);
        else strStatus += "9, a-" + alphabet.get(alphabet.size() - 1);
        strStatus += ").";

        char[] code = new char[lengthCode];

        Random random = new Random();
        code[0] = alphabet.remove(random.nextInt(possibleSymbols - 1) + 1);
        for (int i = 1; i < lengthCode; i++) {
            code[i] = alphabet.remove(random.nextInt(alphabet.size()));
        }

        System.out.println(strStatus);
        return code;
    }
}
