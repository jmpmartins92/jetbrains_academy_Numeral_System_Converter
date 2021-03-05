package converter;

import java.util.Scanner;

import static converter.Converters.*;
import static converter.ErrorChecking.*;

public class Main {

    public static int precision = 5;

    public static String[] splitFrac(String input) {
        return input.split("\\.");
    }

    public static String addPrecisionZeroes(String input) {
        if (input.length() < precision) {
            StringBuilder inputBuilder = new StringBuilder(input);
            while (inputBuilder.length() < precision) {
                inputBuilder.append("0");
            }
            input = inputBuilder.toString();
        }
        return input;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        if (!radixFormatTest(input1)) {
            errorEnd();
        }
        String input2 = scanner.nextLine();
        if (!inputErrorChecks(input1, input2)) {
            errorEnd();
        }

        String input3 = scanner.nextLine();
        if (!radixFormatTest(input3)) {
            errorEnd();
        }

        int radixInput = Integer.parseInt(input1);
        String input = input2;
        int radixOutput = Integer.parseInt(input3);


        if (input.contains(".") && radixInput == 10) {
            System.out.println(fracDecimalConverter(input, radixOutput));
        } else if (input.contains(".") && radixInput != 10){
            System.out.println(fracDecimalConverter(fractionalToDecimal(radixInput, input), radixOutput));
        } else {
            System.out.println(converter(inputDecimal(radixInput, input), radixOutput));
        }


    }
}

