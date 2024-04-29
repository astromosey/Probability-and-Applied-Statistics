import java.io.*;
import java.util.*;

public class Salter {
    public void salt(String fileName, int saltRangeMin, int saltRangeMax) {
        // ArrayList to store x and y values
        ArrayList<String> xyValues = new ArrayList<>();
        File salted = new File("SaltedValues.csv"); 
        // For generating random values
        Random rand = new Random();
        try {
        	// Read the input CSV file containing plotted data
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String nextLine;
            int count = 0;
            // Reads lines of input file
            for (nextLine = bufferedReader.readLine(); nextLine != null; nextLine = bufferedReader.readLine(), count++) {
            	// Skips header
                if (count > 0) {
                // Split each line into x and y values and add them to the ArrayList
                    String[] lineValues = nextLine.split(",");
                    xyValues.addAll(Arrays.asList(lineValues));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Iterate through the ArrayList to apply salt to y values
        for (int i = 0; i < xyValues.size(); i++) {
            if (i % 2 == 1) {
            	// Generate a random salt value within the specified range
                double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
                // Random decision to determine whether to add or subtract salt
                boolean decision = rand.nextBoolean();
                Double temp = Double.parseDouble(xyValues.get(i));
                // Apply salt based on the random decision
                if (decision)
                    temp += saltValue;
                else
                    temp -= saltValue;
                // Update the ArrayList with the salted y value
                xyValues.set(i, temp.toString());
            }
        }
        try {
            // Write the salted data to the output CSV file
            FileWriter fileWriter = new FileWriter(salted);
            for (int i = 0; i < xyValues.size(); i++) {
                fileWriter.write(xyValues.get(i) + ",");
                if (i % 2 != 0)
                    fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


