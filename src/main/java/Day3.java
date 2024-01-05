package src.main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day3Input.txt").toPath());
        int howManyLines = lines.size();
        int lengthOfALine = lines.get(0).length();
        char[][] engine = new char[howManyLines][lengthOfALine];
        int lineNumber = 0;
        int total = 0;
        for (int i = 0; i < lengthOfALine; i++) {
            for (int j = 0; j < howManyLines; j++) {
                engine[i][j] = lines.get(i).charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(engine));
        for (int i = 0; i < lengthOfALine; i++) {
            for (int j = 0; j < howManyLines; j++) {
                String numberToAdd = "";
                if (!(engine[i][j] == '.' || (engine[i][j] >= '0' && engine[i][j] <= '9'))) {
                    System.out.println(engine[i][j]);
                    checkEveryThingAround(engine, i, j, numberToAdd);
                }
            }
        }
    }

    public static void checkEveryThingAround(char[][] engine, int i, int j, String numberToAdd) {
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (engine[i - 1][j - 1] >= '0' && engine[i - 1][j - 1] <= '9') {
                numberToAdd += engine[i - 1][j - 1];
                System.out.println("numbertoadd" + engine[i - 1][j - 1]);
                getWholeNumber(engine, i - 1, j - 1, numberToAdd);
            }
        }

    }

    public static void getWholeNumber(char[][] engine, int i, int j, String numberToAdd) {
        if (engine[i][j - 1] >= 48 && engine[i][j - 1] <= 57) {
            numberToAdd = "" + engine[i][j - 1] + numberToAdd;
        }
        if (engine[i][j - 2] >= 48 && engine[i][j - 2] <= 57) {
            numberToAdd = "" + engine[i][j - 2] + numberToAdd;
        }

        if (engine[i][j + 1] >= 48 && engine[i][j + 1] <= 57) {
            numberToAdd = "" + numberToAdd + engine[i][j + 1];
        }

        if (engine[i][j + 2] >= 48 && engine[i][j + 2] <= 57) {
            numberToAdd = "" + numberToAdd + engine[i][j + 2];
        }

        System.out.println(numberToAdd);
    }

}
