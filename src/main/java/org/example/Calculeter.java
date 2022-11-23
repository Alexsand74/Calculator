package org.example;

public class Calculeter {
    public String calc(String[] arrey) {
        String[] firstNumberArrey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNumberArrey = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanNumeralsArreys = {" ", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String[] mathematicalActionSignArray = {"+", "*", "-", "/"};

        String firstNumber = arrey[0];
        String mathematicalActionSign = arrey[1];
        String secondNumber = arrey[2];
        String statusError = arrey[3];

        int firstIntNumber = -1;
        int firstIntRomanNumber = -1;
        int secondIntNumber = -1;
        int secondIntRomanNumber = -1;
        int statusIntError = 1;
        int result = 0;
        String romanResult = "";

        try {
            statusIntError = Integer.valueOf(statusError);
        } catch (NumberFormatException e) {
            System.err.println(" Неправильный формат перевода строки в число !");
            return romanResult;
        }

        if (statusIntError == 4) {
            System.err.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию  ");
            return romanResult;
        }

        if (!(firstNumber == null)) {
            for (int i = 0; i < firstNumberArrey.length; i++) {
                if (firstNumberArrey[i].equals(firstNumber)) {
                    firstIntNumber = i;
                    firstIntRomanNumber = 0;
                    break;
                }
            }
        }
        if (!(secondNumber == null)) {
            for (int i = 0; i < firstNumberArrey.length; i++) {
                if (firstNumberArrey[i].equals(secondNumber)) {
                    secondIntNumber = i;
                    secondIntRomanNumber = 0;
                    break;
                }
            }
        }
        if (!(firstNumber == null)) {
            for (int i = 0; i < romanNumberArrey.length; i++) {
                if (romanNumberArrey[i].equals(firstNumber)) {
                    firstIntNumber = i;
                    firstIntRomanNumber = 1;
                    break;
                }
            }
        }
        if (!(secondNumber == null)) {
            for (int i = 0; i < romanNumberArrey.length; i++) {
                if (romanNumberArrey[i].equals(secondNumber)) {
                    secondIntNumber = i;
                    secondIntRomanNumber = 1;
                    break;
                }
            }
        }

        if (firstIntRomanNumber == 0 && secondIntRomanNumber == 0) {
            statusIntError = 2;
        } else if (firstIntRomanNumber == 1 && secondIntRomanNumber == 1) {
            statusIntError = 3;
        } else if ((firstIntRomanNumber == 0 && secondIntRomanNumber == 1) || (firstIntRomanNumber == 1 && secondIntRomanNumber == 0)) {
            System.err.println("throws Exception //т.к. используются одновременно разные системы счисления");
            return romanResult;
        }


        if ((statusIntError == 1) || (firstIntRomanNumber == -1) || (secondIntRomanNumber == -1)) {
            System.err.println("throws Exception //т.к. строка не является математической операцией ");
            return romanResult;
        }
        if (statusIntError == 2 || statusIntError == 3) {
            switch (mathematicalActionSign) {
                case "+":
                    result = firstIntNumber + secondIntNumber;
                    break;
                case "*":
                    result = firstIntNumber * secondIntNumber;
                    break;
                case "-":
                    result = firstIntNumber - secondIntNumber;
                    break;
                case "/":
                    if (secondIntNumber == 0) {
                        System.err.println("throws Exception //т.к. на ноль делить нельзя ");
                        return romanResult;
                    } else {
                        result = firstIntNumber / secondIntNumber;
                    }
                    break;
                default:
                    System.err.println("throws Exception //т.к. строка не является математической операцией ");
                    return romanResult;
            }
            if (statusIntError == 3) {
                if (result < 0) {
                    System.err.println("throws Exception //т.к. в римской системе нет отрицательных чисел ");
                    return romanResult;
                } else {
                    if (result > 10) {
                        int i = result / 10;
                        int j = result - (result / 10);
                        romanResult = romanNumeralsArreys[i] + romanNumberArrey[j];
                    } else {
                        romanResult = romanNumberArrey[result];
                    }
                }

            } else {
                romanResult = Integer.toString(result);
            }
        }
        return "Output: \n " + romanResult;
    }
}
