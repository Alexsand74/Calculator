package org.example;

public class Main {
    public static void main(String[] args) {
        DescriptionOutput.descriptionOutput();

        EnteringNumbers enteringNumbers = new EnteringNumbers();
        Calculeter calculeter = new Calculeter();
        System.out.println( calculeter.calc(enteringNumbers.getNumbers()) );
    }
}