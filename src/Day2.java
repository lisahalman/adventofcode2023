package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day2Input.txt").toPath());
        System.out.println(lines);
        for (String line : lines) {
            String[] afterGame = line.split(": ");
            String[] eachGame = afterGame[1].split(";");
            int lengthGame = eachGame.length;
            for (String game : eachGame) {
                String[] color = game.split(",");
                int lengtegame = color.length;
            }
        }


    }


}