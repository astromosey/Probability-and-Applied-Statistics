import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.math4.legacy.analysis.polynomials.PolynomialFunction;

public class Plotter {
    // Method to plot the function and generate a CSV file
    public void plot(String fileName, int min, int max, double interval) {
        // Create a File object with the given file name
        File csvPlot = new File(fileName + ".csv");
        // Define the coefficients of the polynomial function: y = x^2 - 4x + 3
        double[] plotFunction = new double[] {3, -4, 1}; // y = x^2 - 4x + 3
        // Create a PolynomialFunction object representing the polynomial
        PolynomialFunction poly = new PolynomialFunction(plotFunction);
        
        // Define the header for the CSV file
        String header = ("x, y, y = x^2 - 4x + 3");
        // Initialize ArrayLists to store x and y values
        ArrayList<Double> yValues = new ArrayList<>();
        ArrayList<Double> xValues = new ArrayList<>();
        
        try {
            // Create a FileWriter to write data to the CSV file
            FileWriter fWriter = new FileWriter(csvPlot);
            // Write the header to the file
            fWriter.write(header);
            fWriter.write(System.lineSeparator());
            // Initialize the x value
            double x = min + interval;
            // Loop through the range of x values
            for (double counter = min; counter < max; counter += interval) {
                // If it's the first iteration, handle the initial y value
                if (!(counter > min)) {
                    double y = poly.value(min);
                    // Write the x and y values to the file
                    fWriter.write(min + "," + y);
                    // Move to the next line
                    fWriter.write(System.lineSeparator());
                    // Add the y value to the ArrayList
                    yValues.add(y);
                }
                // Check if the next iteration falls within the specified range
                if (counter + interval <= max) {
                    double y = poly.value(x);
                    // Write the x and y values to the file
                    fWriter.write(x + "," + y);
                    // Move to the next line
                    fWriter.write(System.lineSeparator());
                    // Update the x value
                    x += interval;
                    // Add the y value to the ArrayList
                    yValues.add(y);
                }
                // Add the current x value to the ArrayList
                xValues.add(counter);
            }
            // Close the FileWriter
            fWriter.close();
        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();
        }
 
    }
}
