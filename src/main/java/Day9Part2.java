package src.main.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day9Part2 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("C:\\Users\\Lisa\\Documents\\GitHub\\adventofcode2023\\src\\main\\Day9Input.txt").toPath());
        int totalFromEachLineLeft = 0;
        for (String line : lines) {
            String[] listOfNumbersAsString = line.split(" ");
            List<Integer> listOfNumbers = Arrays.stream(listOfNumbersAsString).map(Integer::valueOf).collect(Collectors.toList());
            List<Integer> emptyList = new ArrayList<>();
            List<Integer> emptyListLeft = new ArrayList<>();
            emptyList.add(listOfNumbers.get(listOfNumbers.size() - 1));
            emptyListLeft.add(listOfNumbers.get(0));
            List<Integer> listOfFirstNumber = calculateDifference(listOfNumbers, emptyList, emptyListLeft);
            int totalIntFromLineLeft = methodToGetTopLeft(listOfFirstNumber);
            totalFromEachLineLeft += totalIntFromLineLeft;
        }
        System.out.println(" total part 2: " + totalFromEachLineLeft);
    }

    public static List<Integer> calculateDifference(List<Integer> listOfNumbers, List<Integer> listOfLastNumber, List<Integer> listOfFirstNumber) {
        List<Integer> differences = IntStream.range(0, listOfNumbers.size() - 1)
                .mapToObj(i -> (listOfNumbers.get(i + 1) - listOfNumbers.get(i)))
                .collect(Collectors.toList());
        listOfLastNumber.add(differences.get(differences.size() - 1));
        listOfFirstNumber.add(differences.get(0));
        checkIfAllNumbersAreZero(differences, listOfLastNumber, listOfFirstNumber);
        return listOfFirstNumber;
    }

    public static void checkIfAllNumbersAreZero(List<Integer> differences, List<Integer> listOfLastNumber, List<Integer> listOfFirstNumber) {
        if (!differences.stream().allMatch(i -> i == 0))
            calculateDifference(differences, listOfLastNumber, listOfFirstNumber);
    }

    public static int methodToGetTopLeft(List<Integer> listOfFirstNumber) {
        int downLeft = 0;
        int hoeGrootIsList = listOfFirstNumber.size();
        for (int i = hoeGrootIsList; i > 1; i--) {
            downLeft = listOfFirstNumber.get(i - 2) - downLeft;
        }
        return downLeft;
    }
}