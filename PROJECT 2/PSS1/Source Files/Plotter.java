import java.io.*;
import java.util.*;

public class Plotter {
    // Method to plot data and save it to a CSV file
    public void plot(String fileName, int min, int max, double interval) {
        // Create CSV file
        File plotted = new File(fileName + ".csv");

        // Header for the CSV file
        String header = "x, y, y = x^2 - 4x + 3";

        try {
            // FileWriter object to write to the CSV file
            FileWriter fileWriter = new FileWriter(plotted);

            // Header to the CSV file
            fileWriter.write(header);
            // Move to the next line
            fileWriter.write(System.lineSeparator());

            // Loop through the specified range of x values
            for (double counter = min; counter < max; counter += interval) {
                // Calculate the corresponding y value using the quadratic function
                double y = Math.pow(counter, 2) - 4 * counter + 3;

                // Round the x and y values to the tenth place
                String formattedX = String.format("%.1f", counter);
                String formattedY = String.format("%.1f", y);

                // Write the formatted x and y values to the CSV file
                fileWriter.write(formattedX + "," + formattedY);
                // Move to the next line
                fileWriter.write(System.lineSeparator());
            }
            // Close the FileWriter
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
