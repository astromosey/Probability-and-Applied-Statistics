import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Salter {
    // Method to salt the y-values in a CSV file
    public void salt(String fileName, int saltRangeMin, int saltRangeMax) {
        ArrayList<String> xyValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        ArrayList<Double> xValues = new ArrayList<>();
        File saltedCSV = new File("salted" + fileName);
        // Random object for generating salt values
        Random rand  = new Random();
        
        try (BufferedReader bReader = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            int count = 0;
            // Read each line from the CSV file
            while ((nextLine = bReader.readLine()) != null) {
                if (count > 0) {
                    String[] lineValues = nextLine.split(",");
                    xyValues.addAll(Arrays.asList(lineValues));
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < xyValues.size(); i++) {
            // If the index is even, it represents an x-value
            if (i % 2 == 0)
                xValues.add(Double.parseDouble(xyValues.get(i)));
            // If the index is odd, it represents a y-value
            if (i % 2 == 1) {
                // Generate a random salt value within the specified range
                double saltValue = saltRangeMin + (saltRangeMax - saltRangeMin) * rand.nextDouble();
                // Decide whether to add or subtract the salt value
                boolean decision = rand.nextBoolean();
                // Retrieve the current y-value
                Double temp = Double.parseDouble(xyValues.get(i));
                // Apply salt based on the decision
                if (decision)
                    temp += saltValue;
                else
                    temp -= saltValue;
                // Add the salted y-value to the list
                yValues.add(temp);
                // Update the value in the xyValues list
                xyValues.set(i, temp.toString());
            }
        }
        
        try (FileWriter fWriter = new FileWriter(saltedCSV)) {
            // Write the salted values to the salted CSV file
            for (int i = 0; i < xyValues.size(); i++) {
                fWriter.write(xyValues.get(i) + ",");
                if (i % 2 == 0)
                    fWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();
        }
   
    }
}
