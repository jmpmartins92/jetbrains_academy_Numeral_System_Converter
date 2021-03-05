package converter;

import static converter.Main.addPrecisionZeroes;
import static converter.Main.splitFrac;

public class Converters {

    public static int inputDecimal (int radixInput, String input) {
        int inputDecimal;
        switch (radixInput) {
            case 1:
                inputDecimal = Integer.parseInt(String.valueOf(input.length()), 10);
                break;
            case 10:
                inputDecimal = Integer.parseInt(input);
                break;
            default:
                inputDecimal = Integer.parseInt(String.valueOf(input), radixInput);
                break;
        }
        return inputDecimal;
    }

    public static String converter(int inputDecimal, int radixOutput) {
        if (radixOutput == 1) {
            return "1".repeat(Math.max(0, inputDecimal));
        } else {
            return Integer.toString(inputDecimal, radixOutput);
        }
    }

    public static String fractionalToDecimal(int radixInput, String input) {
        String integerDecimal = String.valueOf(inputDecimal(radixInput, splitFrac(input)[0]));
        String fracInput = splitFrac(input)[1];
        double fracDecimal = 0;
        for (int i = 0; i < fracInput.length(); i++) {
            fracDecimal += inputDecimal(radixInput, Character.toString(fracInput.charAt(i))) / Math.pow(radixInput, i + 1);
        }
        fracDecimal = Double.parseDouble(addPrecisionZeroes(Double.toString(fracDecimal)));
        return String.valueOf(Integer.parseInt(integerDecimal) + fracDecimal);
    }

    public static String fracDecimalConverter(String input, int radixOutput) {
        String fracWithPrecision = addPrecisionZeroes(splitFrac(input)[1]);
        double fracDecimal = Double.parseDouble(fracWithPrecision) / Math.pow(10, fracWithPrecision.length());
        StringBuilder fracResult = new StringBuilder();
        for (int i = 0; i < Main.precision; i++) {
            double auxCalc = fracDecimal * radixOutput;
            System.out.println(auxCalc);
            String[] auxResult = splitFrac(String.valueOf(auxCalc));
            fracResult.append(converter(Integer.parseInt(auxResult[0]), radixOutput));
            System.out.println(fracResult);
            fracDecimal = Double.parseDouble("." + auxResult[1]);
            System.out.println(fracDecimal);

        }
        return converter(Integer.parseInt(splitFrac(input)[0]), radixOutput) + "." + fracResult;
    }
}
