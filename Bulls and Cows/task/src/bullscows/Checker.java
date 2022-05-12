package bullscows;

import java.util.HashSet;

public class Checker {
    public static boolean exit = false;

    public static String checkBulls(char[] answer, char[] code) {
        int bulls = 0;
        int cows = 0;
        HashSet<Character> tmp = new HashSet<>();
        for (char a : code) tmp.add(a);

        assert (answer != null);
        if (code.length != answer.length) {
            System.out.println("Enter correct length.\n code.length = " + code.length +
                    "\t\tanswer.length = " + answer.length + "\n" +
                    "code = " + String.valueOf(code) + "\t\t answer = '" +
                    String.valueOf(answer) + "'");
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
