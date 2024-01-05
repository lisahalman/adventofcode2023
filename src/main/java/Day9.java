package main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day9 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day9Input.txt").toPath());
        int totalFromEachLine = 0;
        for (String line : lines) {
            String[] listOfNumbersAsString = line.split(" ");
            List<Integer> listOfNumbers = Arrays.stream(listOfNumbersAsString).map(Integer::valueOf).collect(Collectors.toList());
            Collections.reverse(listOfNumbers);
            List<Integer> emptyList = new ArrayList<>();
            emptyList.add(listOfNumbers.get(listOfNumbers.size() - 1));
            List<Integer> listOfLastNumber = calculateDifference(listOfNumbers, emptyList);
            int totalIntFromLine = listOfLastNumber.stream().mapToInt(Integer::intValue).sum();
            totalFromEachLine += totalIntFromLine;
        }
        System.out.println(" total : " + totalFromEachLine);
    }

    public static List<Integer> calculateDifference(List<Integer> listOfNumbers, List<Integer> listOfLastNumber) {
        List<Integer> differences = IntStream.range(0, listOfNumbers.size() - 1)
                .mapToObj(i -> (listOfNumbers.get(i + 1) - listOfNumbers.get(i)))
                .collect(Collectors.toList());
        listOfLastNumber.add(differences.get(differences.size() - 1));
        checkIfAllNumbersAreZero(differences, listOfLastNumber);
        return listOfLastNumber;
    }

    public static void checkIfAllNumbersAreZero(List<Integer> differences, List<Integer> listOfLastNumber) {
        if (!differences.stream().allMatch(i -> i == 0))
            calculateDifference(differences, listOfLastNumber);
    }
}