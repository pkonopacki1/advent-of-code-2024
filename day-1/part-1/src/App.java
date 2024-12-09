/*
 * https://adventofcode.com/2024/day/1
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws Exception {
        var input = readInput();
        int[] sortedColumn1 = input[0];
        Arrays.sort(sortedColumn1);
        int[] sortedColumn2 = input[1];
        Arrays.sort(sortedColumn2);

        var result = IntStream.range(0, sortedColumn1.length)
        .map(i -> Math.abs(sortedColumn1[i] - sortedColumn2[i]))
        .sum();
        
        System.out.println("Result: " + result);
    }

    public static int[][] readInput() throws IOException {
        int[][] returnValue = new int[2][1000];
        String line;
        int i = 0;
        try (var reader = Files.newBufferedReader(Path.of("src/input.txt"))) {
            while ((line = reader.readLine()) != null) {
                var splitValue = line.split("   ");
                returnValue[0][i]=Integer.parseInt(splitValue[0]);
                returnValue[1][i]=Integer.parseInt(splitValue[1]);
                i++;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
