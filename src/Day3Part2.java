package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day3Part2 {

    public static Set<String> setOfCoordinatesOfStartOfNumberWhichIsAdded = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day3Input.txt").toPath());
        int howManyLines = lines.size();
        int lengthOfALine = lines.get(0).length();
        char[][] engine = new char[howManyLines][lengthOfALine];
        for (int i = 0; i < lengthOfALine; i++) {
            for (int j = 0; j < howManyLines; j++) {
                engine[i][j] = lines.get(i).charAt(j);
            }
        }
        int sumOfNumbers = 0;
        for (int i = 0; i < lengthOfALine; i++) {
            for (int j = 0; j < howManyLines; j++) {
                if (!(engine[i][j] == '.' || (engine[i][j] >= '0' && engine[i][j] <= '9'))) {
                    long number = checkEveryThingAround(engine, i, j);
                    sumOfNumbers += number;
                }
            }
        }
        System.out.println("Sum: " + sumOfNumbers);
    }

    public static long checkEveryThingAround(char[][] engine, int i, int j) {
        ArrayList<Integer> listOfTotalNumbersAround = new ArrayList<>();
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (engine[i - 1][j - 1] >= '0' && engine[i - 1][j - 1] <= '9') {
                char newNumber = engine[i - 1][j - 1];
                int wholeNumber = getWholeNumber(engine, i - 1, j - 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i - 1][j] >= '0' && engine[i - 1][j] <= '9') {
                char newNumber = engine[i - 1][j];
                int wholeNumber = getWholeNumber(engine, i - 1, j, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i - 1][j + 1] >= '0' && engine[i - 1][j + 1] <= '9') {
                char newNumber = engine[i - 1][j + 1];
                int wholeNumber = getWholeNumber(engine, i - 1, j + 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i][j - 1] >= '0' && engine[i][j - 1] <= '9') {
                char newNumber = engine[i][j - 1];
                int wholeNumber = getWholeNumber(engine, i, j - 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i][j + 1] >= '0' && engine[i][j + 1] <= '9') {
                char newNumber = engine[i][j + 1];
                int wholeNumber = getWholeNumber(engine, i, j + 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i + 1][j - 1] >= '0' && engine[i + 1][j - 1] <= '9') {
                char newNumber = engine[i + 1][j - 1];
                int wholeNumber = getWholeNumber(engine, i + 1, j - 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i + 1][j] >= '0' && engine[i + 1][j] <= '9') {
                char newNumber = engine[i + 1][j];
                int wholeNumber = getWholeNumber(engine, i + 1, j, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
            if (engine[i + 1][j + 1] >= '0' && engine[i + 1][j + 1] <= '9') {
                char newNumber = engine[i + 1][j + 1];
                int wholeNumber = getWholeNumber(engine, i + 1, j + 1, ("" + newNumber));
                if (wholeNumber != 0 ) {
                    listOfTotalNumbersAround.add(wholeNumber);
                }
            }
        }
        if (listOfTotalNumbersAround.size() == 2) {
            long total;
            total = (long) listOfTotalNumbersAround.get(0) * listOfTotalNumbersAround.get(1);
            return total;
        }
        return 0;
    }

    public static int getWholeNumber(char[][] engine, int i, int j, String numberToAdd) {
        StringBuilder startCoordinatesOfNumber = new StringBuilder("" + i + "," + j);
        if (engine[i][j - 1] >= '0' && engine[i][j - 1] <= '9') {
            numberToAdd = "" + engine[i][j - 1] + numberToAdd;
            startCoordinatesOfNumber.replace(startCoordinatesOfNumber.lastIndexOf(String.valueOf(j)), 10, String.valueOf(j - 1));
            if ((engine[i][j - 2] >= '0' && engine[i][j - 2] <= '9')) {
                numberToAdd = "" + engine[i][j - 2] + numberToAdd;
                startCoordinatesOfNumber.replace(startCoordinatesOfNumber.lastIndexOf(String.valueOf(j - 1)), 10, String.valueOf(j - 2));
            }
        }
        if (engine[i][j + 1] >= '0' && engine[i][j + 1] <= '9') {
            numberToAdd = "" + numberToAdd + engine[i][j + 1];
            if (engine[i][j + 2] >= '0' && engine[i][j + 2] <= '9') {
                numberToAdd = "" + numberToAdd + engine[i][j + 2];
            }
        }
        if (checkIfNumberIsNotADuplicate(startCoordinatesOfNumber.toString())) {
            return Integer.parseInt(numberToAdd);
        }
        return 0;
    }

    public static boolean checkIfNumberIsNotADuplicate(String startCoordinatesOfNumber) {
        return setOfCoordinatesOfStartOfNumberWhichIsAdded.add(startCoordinatesOfNumber);
    }
}
