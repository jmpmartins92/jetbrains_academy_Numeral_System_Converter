package converter;

public class ErrorChecking {

    public static boolean inputErrorChecks(String radixInput, String input) {
        int largestChar = 0;
        if (radixInput.equals("1")) {
            if (!input.matches("1+")) {
                return false;
            } else {
                return true;
            }
        } else {
            for (int charIndex = 0; charIndex < input.length(); charIndex++) {
                if (input.charAt(charIndex) == '.') {
                    continue;
                } else if (input.charAt(charIndex) > largestChar) {
                    largestChar = Character.getNumericValue(input.charAt(charIndex));
                }
                if (largestChar >= Integer.parseInt(radixInput)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean radixFormatTest(String radix) {
        if (!radix.matches("[0-9]{1,2}")) {
            return false;
        } else if (Integer.parseInt(radix) < 1 || Integer.parseInt(radix) > 36) {
            return false;
        }
        return true;
    }
    public static void errorEnd() {
        System.out.println("error");
        System.exit(0);
    }
}
