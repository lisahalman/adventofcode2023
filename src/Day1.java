package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day1Input.txt").toPath());
        int totalPartOne = 0;
        for (String line : lines) {
            int first = 0;
            StringBuilder newLine = new StringBuilder(line);
            boolean isReplaced = true;
            while (isReplaced) {
                isReplaced = false;
                if (newLine.indexOf("oneight") > -1) {
                    String one = "oneight";
                    String oneNum = "18";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("twone") > -1) {
                    String one = "twone";
                    String oneNum = "21";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("threeight") > -1) {
                    String one = "threeight";
                    String oneNum = "38";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("fiveight") > -1) {
                    String one = "fiveight";
                    String oneNum = "58";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("sevenine") > -1) {
                    String one = "sevenine";
                    String oneNum = "79";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("eightwo") > -1) {
                    String one = "eightwo";
                    String oneNum = "82";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("nineight") > -1) {
                    String one = "nineight";
                    String oneNum = "98";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("one") > -1) {
                    String one = "one";
                    String oneNum = "1";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("two") > -1) {
                    String one = "two";
                    String oneNum = "2";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("three") > -1) {
                    String one = "three";
                    String oneNum = "3";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("four") > -1) {
                    String one = "four";
                    String oneNum = "4";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("five") > -1) {
                    String one = "five";
                    String oneNum = "5";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("six") > -1) {
                    String one = "six";
                    String oneNum = "6";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("seven") > -1) {
                    String one = "seven";
                    String oneNum = "7";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("eight") > -1) {
                    String one = "eight";
                    String oneNum = "8";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
                if (newLine.indexOf("nine") > -1) {
                    String one = "nine";
                    String oneNum = "9";
                    int indexBegin = newLine.indexOf(one);
                    int indexEind = newLine.indexOf(one) + one.length();
                    newLine.replace(indexBegin, indexEind, oneNum);
                    isReplaced = true;
                }
            }
            line = newLine.toString();
            for (char num : line.toCharArray()) {
                if (num < 58) {
                    first = Character.getNumericValue(num);
                    break;
                }
            }
            int last = 0;
            StringBuilder backwards = new StringBuilder(line);
            backwards.reverse();
            for (char num : backwards.toString().toCharArray()) {
                if (num < 58) {
                    last = Character.getNumericValue(num);
                    break;
                }
            }
            String totalInLine = "" + first + last;
            int addedUp = Integer.parseInt(totalInLine);
            totalPartOne += addedUp;
        }
        System.out.println(totalPartOne);
    }
}