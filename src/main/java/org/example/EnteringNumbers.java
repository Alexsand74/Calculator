package org.example;

import java.util.Scanner;
import java.util.StringTokenizer;

class EnteringNumbers {

    String [] getNumbers () {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        String[] temporaryArrayStrings = new String[4];
        String[] words = number.split(" ");

        if (words.length == 3) {
            for (int i = 0; i < 3; i++) {
                temporaryArrayStrings[i] = words[i];
            }
            temporaryArrayStrings[3] = "2";
        } else if (words.length > 3) {
            temporaryArrayStrings[3] = "4";

        } else if (words.length == 1) {
            temporaryArrayStrings[3] = "1";
            final String[] characterArray = new String[]{"+", "*", "-", "/"};
            String[] tempArrayStrings;
            int j = 0;
            do {
                tempArrayStrings = getTokens(number, characterArray[j]);
                if (tempArrayStrings.length == 2) {
                    temporaryArrayStrings[0] = tempArrayStrings[0];
                    temporaryArrayStrings[1] = characterArray[j];
                    temporaryArrayStrings[2] = tempArrayStrings[1];
                    temporaryArrayStrings[3] = "2";
                    break;
                }
                j++;
            } while (j < 4);

            if (tempArrayStrings.length > 2) {
                temporaryArrayStrings[3] = "4";
            } else if (tempArrayStrings.length < 2) {
                temporaryArrayStrings[3] = "1";
            }

        }

        String firstNumber = temporaryArrayStrings[0];
        String secondNumber = temporaryArrayStrings[2];
        String mathematicalActionSign = temporaryArrayStrings[1];
        String statusError = temporaryArrayStrings[3];


//        System.out.println("Первое число [0] " + firstNumber);
//        System.out.println("знак между ними [1] " + mathematicalActionSign);
//        System.out.println("Второе число [2] " + secondNumber);
//        System.out.println("статус ошибки [3] " + statusError);

        return temporaryArrayStrings;
    }

    private String[] getTokens (String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            result[i++] = stringTokenizer.nextToken();
        }
        return result;
    }
}



